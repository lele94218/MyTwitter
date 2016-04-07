social_network_paper
====================

## 简介

1. 分析社交网络数据, 进行好友推荐功能实现. 算法基本实现完成, 完成展示 Web 应用的后端实现.

============
## 介绍

1. Java Web 应用, 用于毕业设计算法演示

2. MVC 设计模式, 技术选型：

    - Controller: Spring MVC
    
    - Model: Spring Data, Hibernate, JPA
    
    - View: JSP, JavaScript 
    
===
## 算法思路

1. 使用 Elasticsearch 对 Tweets 进行索引, 对每个用户索引 500 - 1000 词

2. Elasticsearch 与 Wordnet 结合进行搜索, 获得指数