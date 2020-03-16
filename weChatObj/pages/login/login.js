// pages/login/login
// 获取app.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: {},
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    serveraddr: app.globalData.serveraddr,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //判断是否存在 userinfo
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
      //由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
    } else if (this.data.canIUse) {
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
      //在没有 open-type=getUserInfo 版本 的兼容处理 
    } else {
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo;
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }

    wx.request({
      url: app.globalData.serveraddr + 'wx/order/queue?openid=' + app.globalData.openid,
      success: res => {
        // console.log(res.data.orderid)
        // console.log(res.data.orders)
        this.setData({
          queue: res.data
        });
      }
    })
  },
  
  //客户登录或者注册
  getUserInfo: function (e) {
    /*判断小程序中的openid是否存在。
      说明：获取openid需要从微信的官方去获取，这个获取的时间不一定，可能存在
      一定的延迟。如果还没有获取到openid的时候就去点击授权登录按钮，那么这个时候
      是不能进行后端的操作的。（这是不能有任何的操作）
    */
    if (app.globalData.openid == null) {
      return;
    }
    wx.getUserInfo({
      success: res => {
        app.globalData.userInfo = res.userInfo
        // console.log(app.globalData)
        wx.request({
          url: app.globalData.serveraddr + 'wx/customer/login',
          //data是需要传递到后端的两个参数，参数名称需要和Customer类中的属性名一致
          data: "nickname=" + app.globalData.userInfo.nickName + "&openid=" + app.globalData.openid,
          method: "POST",
          header: {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          success: r => {
            // console.log(r)
            // console.log(r.data)
            //如果r.data>0，那么说明登录注册成功，那么需要跳转到菜单页面。否则说明登录注册失败，那么应该给客户一个提示
            if (r.data > 0) {
              //成功，后续逻辑：判断用户是否有正在处理的订单，如果有，那么跳转到订单页面；如果没有跳转到菜单页面。          
              wx.request({
                url: app.globalData.serveraddr + 'wx/order/queue?openid=' + app.globalData.openid,
                success: res => {
                  // console.log(res.data)
                  if (res.data != "") {
                    wx.navigateTo({
                      url: '../queue/queue',
                    })
                  }
                  else {
                    //1、先完成菜单显示功能,直接跳转到menu界面
                    wx.navigateTo({
                      url: '../menu/menu',
                    })
                  }
                }
              })

              // //1、先完成菜单显示功能,直接跳转到menu界面
              // wx.navigateTo({
              //   url: '../menu/menu',
              // })
                  
            } else {
              //失败
              wx.showModal({
                title: '提示',
                content: '你将无法正常使用小程序',
              })
            }

          }
        })
      }
    })

    // console.log(e);
    // app.globalData.userInfo = e.detail.userInfo;
    // if (e.detail.userInfo) {
    //   wx.navigateTo({
    //     url: '/pages/menu/menu',
    //   })
    // } else {
    //   wx.showModal({
    //     title: '提示',
    //     content: '你将无法正常使用小程序',
    //   })
    // }
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