# Todo 待办清单

> 模块化分：
>	- parent ： 所有模块的父模块
>	- model：实体模块（待办事项）
>	- repository：资源库层
>	- web ： 表现层
	
## 7.5 集成测试

### 给repository 添加H2实现（H2ToDoRepository）

### 编写测试类
	
	- 集中测试的类名以IntegTest结尾
	- 与单元测试的类放在同一包下

### 在构建中支持集中测试

		三点要求
	- 提供独立的task来执行单元测试和集成测试
	- 分离单元测试和集成测试的运行结果和报告
	- 让集成测试作为验证生命周期task check的一部分
	
### 为集成测试建立srouce sets

### 引导测试环境 

## 7.6 功能测试
### 在构建中支持功能测试
	
	- 声明功能测试配置和依赖
	- 定义sourcesSet和试task
	- 在functionalTest task中使用sourcesSet
	- 为功能测试声明增强的jetty task
	
### 将功能测试集成到构建的生命周期中

## 7.7 总结 