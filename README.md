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
|qutype|varchar(10)|题目类型|
|qudetail|varchar(350)|题目内容|
|quans|varchar(350)|题目答案|
|quval|float|题目分值|
|qudifficulty|int|题目难度|
|schoolname|varchar(30)|学校姓名|
|schooltype|varchar(30)|试题难度类型(小学,高中,大学)|


### questiontag
>知识点表

|key|date|description|
|---|---|---|
|tagid|int|知识点id|
|tagname|varchar(16)|知识点名称|

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




## api接口通信规范

### 用户模块

#### 登录

**传入**

|key|type|
|----|----|
|username|string|
|password|string|

**返回**

|key|type|description|
|----|----|----|
|state|string|error/success|
|token|string||
|response|string|出错信息/或者返回的用户种类|
> 如果state是error
> 返回的是出错信息
> 如果是state是success
> 返回是登录用户的身份

#### 用户信息查询

api:

|key|value|
|----|---|
|nums|int|
|user||
返回对于每个用户
|key|type|description
|---|---|---|
|userid|int|唯一的标识|
|username|string||
|usertype|string|两种questionrecorder,或questionadmin|
|useremail|string||
|userphone|string|
**for example**
```json
{
    "nums":1,
    "1":{
        "userid":"1",
        "username":"langman",
        "usertype":"questionadmin",
        "useremail":"langman@gmail.com",
        "userphone":"10086"
    }
}
```
#### 用户删除

**传入**
api:
|key|type|
|---|---|
|userid|int|

**返回**
|key|type|description|
|---|---|---|
|state|string|error,success|
|information|string|报错信息，如果是error的话|
