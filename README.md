### AndroidPractice
---
### Room
1. 集合Android architecture 使用Room对Sqlite数据库进行封装
   > Room对数据库的增删改查
2. Room和Rxjava 的Flowable相结合
### Realm
1. Realm 数据库的引入
2. Realm 对数据进行增删改查
3. Realm 对数据分析（Realm studio java 平台）
### Retrofit
1. Retrofit的基本使用 
2. Retrofit的get post方法
3. OkhttpClient 添加interceptor
4. Retrofit 和 Rxjava 相结合
### Rxjava
1. 基本概念里面
2. map
3. just
4. fromArray
5. fromIterable
6. time
7. defer
8. flatMap
9. zip
9. concat
10. concatMap
11. merge
12. all
13. timeWhile
14. shipWhile
15. collect
16. range
17. interval
18. intervalRange
> 重点区分  **concat merge flatMap concatMap**

 * concat: 组合多个被观察者一起发送数据，合并后 按发送顺序串行执行
 * merge: 组合多个被观察者一起发送数据，合并后 按时间线并行执行
 * concatMap 将被观察者发送的事件序列进行 拆分&单独转换，再合并成一个新的事件序列，最后再进行发送
 * flatMap  拆分&重新合并生成的事件序列 的顺序 = 被观察者旧序列生产的顺序
### Rxjava 的使用场景

1. 取数据先检查缓存情景
2. 等到多个接口并发取完数据
3. 一个接口的请求依赖另一个Api数据的返回
4. 界面按钮需要防止连续点击的情况
5. 响应式的界面
6. 复杂的数据变化

### MAP
1. 对基类BaseView，BasePresenter 的封装
2. 对于IViewContract的讲解
3. 创建模板MVPContract
### 懒加载
1. BaseLazyFragment的原理理解
2. 对其进行封装
### View&ViewGroup的事件分发
1. dispatchTouchEvent  分发点击事件
2. onInterceptTouchEvent  判断是否拦截某个事件
3. onTouch
4. onTouchEvent 处理点击事件
5. onClick
### EmptyLayout
1. 网络判断
2. Loading加载动画
3. 无网络 从新加载数据
### RxPreference
1. rx从sp中获取数据
### RxLifeCycle
1. 对activity生命周期
2. 对Fragment生命周期
### View截图
1. 保存为Bitmap对象
### Handler LOOP MessagQueue Thread
1. handler
### Readhub
1. 从Readhub获取数据
### Gank.io
1. 从Gank.io获取数据
### 自定义View
1. 继承现有的View
2. SquareImageView
3. 动态改变父View的宽高
4. 动态改变View的宽高
### View
1. 画圆
2. 画椭圆
3. 画弧度
4. 画圆角矩形
5. 画Bitmap
6. 画点
7. 画矩形
8. 画柱形图
9. 画饼形图
### WebView
1. tencent X5浏览器内核
2. 与WebKit的比较





