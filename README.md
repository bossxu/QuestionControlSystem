# QuestionControlSystem


## 项目名称：
# 试题库管理系统

### 项目目的：
+ 作业，数据库作业，不写得gg
+ 熟悉一下后台加数据库的操作

### 项目要求

+ 试题库中主要存放各校的测验真题，试题库应包含学校、学校性质、科目、年级题型、难度系数、知识点等，这些均可由试题管理员进行添加、删除、修改。

+  用户提供的纸质考卷，开发者必须提供试题导入模板（包括答案），供用户按模板格式输入后导入系统，模板里要提供每题的题型、难度系数和涉及知识点；（题目中有公式和图片）

+  试卷导入：导入一套试卷时要先选择学校、科目、年级、试卷信息（如某年的期中卷等），导入后要进行查重，如同一所学校已有同一题则不再添加；（试题录入员）

+  试卷生成：试题管理员可以根据各种要求进行组卷，如：
   + 自动组卷：如兰生复旦7年级综合卷，选择学校、科目、年级，然后输入试题抬头、总分，选择需要的题型，指定各题型的题目数量，每题分数，难度要求等。自动生成一套试卷，供下载；

   + 手动组卷：如兰生复旦7年级综合卷，选择学校、科目、年级，然后输入试题抬头、总分，选择需要的题型和难度，显示相应题目，手动选择，输入分值，一直到组好一份试卷，供下载；

   + 可根据知识点组卷，也可根据题型组卷；可按学校、也可按学校性质组卷；

   +   每生成一套试卷，同时生成一套解答供下载；

   +   总之一句话，提供尽可能多的灵活性。

+ 用户：试题录入员、试题管理员、超级用户；

+ 请特别注意实用性，尽可能让用户使用方便。

### 项目技术栈

+ 前后段分离
+ 前端vue，后台springboot，http通信
+ 数据库采用mysql
+ 通信内容采用json格式

# 项目分析

## 功能分析

+ 用户 
+ 题目管理
+ 用户管理
+ 组卷功能，不同的画像对应不同的试卷。


## 数据库设计

### userdate
> 用户表

|key|type|
|---|---|
|username|varchar(20)|
|userpwd|varchar(20)|
|usertype|int|

### questiondate
>问题表  

|key|date|description|
|----|---|---|
|quid|int|题目id|
|qutype|varchar(10)|题目类型,(数学,物理)|
|qudetail|varchar(350)|题目内容|
|quans|varchar(350)|题目答案|
|quval|float|题目分值|
|qudifficulty|int|题目难度|
|schoolname|varchar(30)|学校姓名|
|schooltype|varchar(30)|试题难度类型(小学,高中,大学)|


### questiontag
> 知识点表

|key|date|description|
|---|---|---|
|tagid|int|知识点id|
|tagname|varchar(16)|知识点名称|

### level
> 年级表

|key|type|description|
|---|---|---|
|levid|int||
|levelname|string||

### exampaper
> 试卷表

|key|type|description|
|---|---|---|
|examid|string||
|examdate|string||
|examname|string||

### tagconnect
> 知识点题目联系表

|key|type|description|
|---|---|---|
|quid|int|题目编号|
|tagid|int|知识点编号|

### levelconnect
> 年级题目联系表

|key|type|description|
|----|----|---|
|quid|int|题目号|
|levelid|int|年级号|

### examconnect
> 试卷题目联系表

|key|type|description|
|---|---|---|
|examid|int||
|examid|int||


## api接口通信规范

### 用户模块

#### 注册
api: **post /api/user/registe**  
```json
postbody:
{
	"username":"langman",
	"userpwd":"1998129"
}
response:
{
    "response": {
        "usertype": 0,
        "id": 1,
        "username": "langman"
    },
    "state": "success"
}
```

#### 登录
api: **post /api/user/login**
```json

postbody:
    {
        "username":"langman",
        "userpwd":"1998129"
    }
response:
success:
{
    "response": {
        "usertype": 0,
        "id": 1,
        "username": "langman"
    },
    "state": "success"
}
error:
{
    "response": "登陆出错，用户名不存在或密码错误",
    "state": "error"
}

```
#### 获取所有用户
api: **Get /api/user/all**
```json
response:
[
    {
        "id": 1,
        "username": "langman",
        "userpwd": "1998129",
        "usertype": 0
    }
]
```
#### 获取单个用户
api: **Get /api/user/{id}**
```json
response:
{
    "id": 1,
    "username": "langman",
    "userpwd": "1998129",
    "usertype": 0
}

```
#### 删一个用户
api: **Delete /api/user/{id}**
```json
response:
{
    "state": "SUCCESS"
}
```

### 题目模块

#### 创建一个题目
api: **post /api/question/create**

```json
postbody:
{
        "qutype":"选择题",
        "qudetail":"1+1=?",
        "quans":"2",
        "quval":1,
        "qudifficult":1,
        "schoolname":"上海大学",
        "schooltype":"理工类",
        "taglist":["math","算术"],
        "levellist":["大一","大二"],
        "examlist":["大一数学系月考","一年级数学系期末考"]
   }
response:
{"state":"success"}

```
#### 题目列表
api: **Get /api/question/all**  
返回的是一个列表然后是基础信息
```json
response:
[
    {
        "quid": 8,
        "quval": 1,
        "qudifficult": 1,
        "schoolname": "上海大学",
        "schooltype": "理工类",
        "taglist": [
            "math",
            "算术"
        ]
    }
]

```
#### 获取单个题目
api: **Get /api/question/{id}**
```json
response:{
             "quid": 8,
             "qutype": "数学",
             "qudetail": "1+1=?",
             "quans": "2",
             "quval": 1,
             "qudifficult": 1,
             "schoolname": "上海大学",
             "schooltype": "理工类",
             "taglist": [
                 {
                     "tagid": 6,
                     "tagname": "math"
                 },
                 {
                     "tagid": 7,
                     "tagname": "算术"
                 }
             ],
             "levelList": [
                 {
                     "levid": 4,
                     "levelName": "大一"
                 },
                 {
                     "levid": 5,
                     "levelName": "大二"
                 }
             ],
             "examlist": [
                 {
                     "examid": 2,
                     "examname": "大一数学系月考",
                     "examdate": "2019-05-21 22:49:19"
                 },
                 {
                     "examid": 3,
                     "examname": "一年级数学系期末考",
                     "examdate": "2019-05-21 22:49:19"
                 }
             ]
         }

```

#### 单个题目更改
api:**Post /api/question/create**
```json
postbody:
{
    "quid": "8",
    "qutype": "数学",
    "qudetail": "1+1=?",
    "quans": "3",
    "quval": 1,
    "qudifficult": 1,
    "schoolname": "上海大学",
    "schooltype": "理工类",
    "taglist": [
        "math",
        "算术"
    ],
    "levellist": [
        "大一",
        "大二"
    ],
    "examlist": [
        "大一数学系月考",
        "一年级数学系期末考"
    ]
}
response:
{
    "state": "success"
}

```

#### 删除题目


#### 题目查询
api **Post /api/question/search**
> 根据关键字进行查找

```json
postbody:
{
	"keyword":"上海"
}
response:
[
    {
        "quid": 9,
        "quval": 1,
        "qudifficult": 1,
        "schoolname": "上海大学",
        "schooltype": "理工类",
        "taglist": [
            "算术",
            "math"
        ]
    }
]
```
### tag模块

#### 获取所有tag
api: **Get /api/tag/all**
```json
response:
[
    {
        "tagid": 6,
        "tagname": "math"
    },
    {
        "tagid": 7,
        "tagname": "算术"
    }
]
```
#### 创建一个tag
api: **post /api/tag/all**
```json
postbody:
{
	"tagname":"上海"
}
response:
{
    "state": "success"
}
```

#### 删除一个tag
api: **delete /api/tag/delete/{id}**
```json
response:
{
    "state": "success"
}
```
#### 获取这个tag搭边的所有题目
api: **Get /api/tag/questions/{id}**
```json
response:
[
    {
        "quid": 9,
        "quval": 1,
        "qudifficult": 1,
        "schoolname": "上海大学",
        "schooltype": "理工类",
        "taglist": [
            "算术",
            "math"
        ]
    }
]
```

### 年级搭边
#### 获得所有的年级
api: **Get /api/level/all**
```json
response:
[
    {
        "levid": 4,
        "levelName": "大一"
    },
    {
        "levid": 5,
        "levelName": "大二"
    }
]
```

### 试卷搭边
#### 获得所有的试卷
api: **get /api/exam/all**
```json
response:
[
    {
        "examid": 2,
        "examname": "大一数学系月考",
        "examdate": "2019-05-21 22:49:19"
    },
    {
        "examid": 3,
        "examname": "一年级数学系期末考",
        "examdate": "2019-05-21 22:49:19"
    }
]
```
#### 获得某个试卷里面所有的信息
api:**Get /api/exam/questions/{id}**
```json
response:
[
    {
        "quid": 9,
        "quval": 1,
        "qudifficult": 1,
        "schoolname": "上海大学",
        "schooltype": "理工类",
        "taglist": [
            "算术",
            "math"
        ]
    }
]
```
## 组卷

> 还不晓得怎么搞，先写那个给我的值把

|key|type|description|
|----|----|----|
|qutype|String|这个是固定的几个标签，数学还是物理啥的|
|quval|int|这个是这个卷子的总分数|
|qudifficult|int|这个是卷子的难度定义|
