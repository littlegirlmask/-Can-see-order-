
// pages/menu/menu.js
var app = getApp();// 获取app.js
var sliderWidth = 96;// 设置 slider 用于计算中间位置
//定义空数组
// var nameList = [];
//定义空的订单列表
var orderList = [];

Page({

  /**
   * 页面的初始数据
   */
  data: {
    menudto: {},//商品类型类别和商品列表
    us: {},
    activeIndex: 1,
    sliderOffset: 0,
    sliderLeft: 0,
    shopNum: 0,
    totalprice: 0,
    newOrder: null,
    positionValue: 'none',
    topValue: null,
    bottomValue: null,
    serveraddr: app.globalData.serveraddr
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //捕获this
    var that = this;
    // console.log(that.data)

    //请求后台接口获取菜单数据
    wx.request({
      url: app.globalData.serveraddr + 'wx/menu',
      success: res => {
        this.setData({
          menudto: res.data
        })
      }
    })

    // 捕获系统信息
    wx.getSystemInfo({
      success: function (res) {
        // console.log(taht.data)
        that.setData({
          // sliderLeft:(res.windowWidth / that.data.menudto.goodstypelist.length - sliderWidth) / 2,
          // sliderOffset: res.windowWidth / that.data.menudto.goodslist.length * that.activeIndex
          // //计算初始偏移量
          sliderLeft: (res.windowWidth / 4 - sliderWidth) / 2,
          // //计算每次移动的偏移量
          sliderOffset: res.windowWidth / 4 * that.activeIndex
        });
      }
    });

    if (app.globalData.userInfo) {
      this.setData({
        us: app.globalData.userInfo
      })
    }
  },

  /**
     * 滚动监听
     */
  onPageScroll: function (e) {
    var that = this;
    if (e.scrollTop >= 20) {
      that.setData({
        positionValue: 'fixed',
        topValue: 0,
        bottomValue: 120
      })
    } else {
      that.setData({
        positionValue: 'none',
        topValue: 0
      })
    }
  },

  // 选项卡切换
  tabClick: function (e) {
    // console.log(e)
    this.setData({
      sliderOffset: e.currentTarget.offsetLeft,
      activeIndex: e.currentTarget.id
    });
  },

  // 减少选菜
  buttonsub: function (e) {
    var dto = this.data.menudto;
    for (var j = 0; j < dto.goodslist.length; j++) {
      if (dto.goodslist[j].gid == e.currentTarget.dataset.gid) {
        if (dto.goodslist[j].gcount > 0) {
          //菜品数量-1
          dto.goodslist[j].gcount = dto.goodslist[j].gcount - 1;
          //总数量-1
          var snum = this.data.shopNum - 1;
          //重新计算总价
          var tprice = this.data.totalprice - e.currentTarget.dataset.gprice
          // //获取单个菜品的全部信息
          // var goods = { "gid": e.target.dataset.gid, "gname": e.target.dataset.gname, "gprice": e.target.dataset.gprice, "gimg": e.target.dataset.gimg, "gcount": dto.goodslist[j].gcount };
          // orderList.pop(goods);
          //回写数据
          this.setData({
            menudto: dto,
            shopNum: snum,
            totalprice: tprice,
            // newOrder: orderList
          })
        }
      }
    }
  },
  // 增加选菜
  buttonadd: function (e) {
    // 菜单
    var dto = this.data.menudto;
    //遍历菜单
    for (var j = 0; j < dto.goodslist.length; j++) {
      //如果菜单中的gid和页面上点击的按钮对应，那么执行下面的内容
      if (dto.goodslist[j].gid == e.currentTarget.dataset.gid) {
        // 对应菜品数量+1
        dto.goodslist[j].gcount += 1;
        // 总菜品数量+1
        var snum = this.data.shopNum + 1;
        // 计算总价格
        var tprice = this.data.totalprice + e.currentTarget.dataset.gprice;
        // //获取单个菜品的全部信息
        // var goods = {"gid": e.target.dataset.gid, "gname": e.target.dataset.gname, "gprice": e.target.dataset.gprice, "gimg": e.target.dataset.gimg, "gcount": dto.goodslist[j].gcount};
        // orderList.push(goods);
        //设置数据
        this.setData({
          menudto: dto,
          shopNum: snum,
          totalprice: tprice
          // newOrder:orderList
        })
      }
    }
  },
  //订单选项
  addorder: function (e) {
    console.log(e)
    if (this.data.shopNum > 0) {
      wx.request({
        url: app.globalData.serveraddr + 'wx/order/add?openid=' + app.globalData.openid + '&totleprice=' + this.data.totalprice,
        data: JSON.stringify(this.data.menudto.goodslist),
        method: "POST",
        header: {
          "Content-Type": "application/json"
        },
        success: r => {
          if (r.data == 1) {
            wx.navigateTo({
              url: '../queue/queue',
            })
          } else if (r.data == 2) {
            wx.showToast({
              title: '您还未注册看得见点餐系统哦',
              icon: 'loading',
              duration: 2000,
              mask: true
            })
          } else {
            wx.showToast({
              title: '下单失败',
              icon: 'loading',
              duration: 2000,
              mask: true
            })
          }
        }
      })
    } else {
      wx.showToast({
        title: '还未点餐',
        icon: 'loading',
        duration: 2000,
        mask: true
      })
    }
    //   wx.navigateTo({
    //     // url: '../queue/queue?shopNum=' + e.target.dataset.shopnum + '&totalprice=' + e.target.dataset.totalprice + '&gorder=' + JSON.stringify(e.target.dataset.orderlist) ,
    //     url: app.globalData.serveraddr + 'wx/order/add?openid=' + app.globalData.openid +'&totalprice='+app.globalData.totalprice,

    //   })
    // }else{
    //   //显示消息提示
    //   wx.showToast({
    //     title: '还未点餐',
    //     icon:'loading',
    //     duration:2000,
    //     mask:true
    //   })
    // }
  },

  //详情页面显示
  showDetails: function (e) {
    // console.log(e);
    wx.navigateTo({
      url: '../info/info?gimg=' + e.target.dataset.gimg + '&gname=' + e.target.dataset.gname + '&gcontent=' + e.target.dataset.gcontent + '&gprice=' + e.target.dataset.gprice + '&gtime=' + e.target.dataset.gtime,
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})
