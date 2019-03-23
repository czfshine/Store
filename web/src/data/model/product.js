/**
 * 与服务器的product 实体相对应
 */

 //import getModelLink from '../links.js'
 class Product {
    constructor() {
        //这个是显示到table需要的信息
        this.columns = [
        //  json属性的键值   显示出来的标题  预期宽度  是否隐藏
        { dataKey: 'proid', title: 'ID', width: 50, hidden: true },
        //                                                 //数据类型      数字的分隔符
        // { dataKey: 'country', title: '国家', width: 200, type: 'money', delimiter: ',' },
                                                    //默认按这一列排序
        { dataKey: 'name', title: '商品名', width: 150, ordered: true },
        { dataKey: 'size', title: '规格' }];
        //this.link=getModelLink("products");
        this.link="/data/products"
      }
    
 }
 
 export default Product;