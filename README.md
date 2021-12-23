# 指南

## 项目介绍

一个基于 Spring Boot 2.x、Mabatis、shiro、JWT、redis、Vue、Element-UI 的前后端分离的后台管理系统

> 本系统的初衷就是尽力解放双手，把尽可能多的经历放在业务逻辑上。

## 快速了解

### 项目简介

------

TK - ADMIN 基于 Spring Boot 2.x、Mybatsi、Shiro、JWT、Vue等前沿技术实现的前后端分离的后台管理系统，项目采用单体分模块的开发方式，权限控制采用 RBAC 思想。

### 主要特性

------

- 谁用最新的技术栈
- 前后端统一异常拦截处理，统一输出异常，避免繁琐的判断
- 支持在线用户管理

### 主要功能

------

- 用户管理

### 项目结构

------

- ``tkadmin-common``为系统的公共模块，各种工具类，公共配置存在该模块
- ``tkadmin-system``为系统核心模块
- ``tkadmin-logging``为系统的日志模块
- ``tkadmin-tools``为第三方工具模块，包含：图床、邮件、支付宝等
- ``tkadmin-generator``为系统的代码生成模块，代码生成的模板在 system 模块中
- ``tkadmin-starter``为项目入口模块，也是最终需要打包部署的模块

### 详细结构

------

```
-tkadmin-common 公共模块
	-
-eladmin-system 系统核心模块
-tkadmim-logging 系统日志模块
-tkadmin-tools 系统第三方工具模块
-tkadmin-generator 系统代码生成模块
-tkadmin-starter 系统启动入口
```

