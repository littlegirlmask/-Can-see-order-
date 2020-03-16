// pages/queue/queue.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    positionValue: 'none',
    topValue: null,
    queue: {},
    orderid:null,
    serveraddr: app.globalData.serveraddr
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },
  /**
   * 滚动监听
   */
  onPageScroll: function (e) {
    var that = this;
    if (e.scrollTop >= 60) {
      that.setData({
        positionValue: 'fixed',
        topValue: 0
      })
    } else {
      that.setData({
        positionValue: 'none',
        topValue: 0
      })
    }
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    this.showQueue();
    setInterval(this.showQueue, 60 * 1000);
  },

  showQueue: function () {
    wx.request({
      url: app.globalData.serveraddr + 'wx/order/queue?openid=' + app.globalData.openid,
      success: res => {
        console.log(res.data)
        this.setData({
          queue: res.data
        });
      }
    })
  },
  //取消订单选项
  clearOrder: function (e) {
    console.log(e)
    //显示提示信息
    wx.showModal({
      content: '确定要取消订单吗？',
      cancelColor: "#333",
      success(res) {
        if (res.confirm) {
          // 更新数据绑定变量
          wx.request({
            url: app.globalData.serveraddr + 'wx/order/cancel?orderid=' + e.currentTarget.dataset.orderid,
            success: res => {
              console.log(res.data)
              if (res.data > 0){
                console.log("成功修改")
              }
            }
          });
          console.log("success")
          wx.navigateTo({
            url: '../menu/menu'
          })
        }
      }
    })
  },

  //去支付选项
  payOff: function (e) {
    // console.log(e.currentTarget.dataset.orderid)
    // console.log(e.currentTarget.dataset.sum)
    if (this.data.queue.orders.ordertotleprice > 0) {
      wx.navigateTo({
        url: '../payoff/payoff?sum=' + e.currentTarget.dataset.sum + '&id=' + e.currentTarget.dataset.id,
      })
    } else {
      //显示消息提示
      wx.showToast({
        title: '订单不存在!',
        duration: 2000,
        mask: true
      })
    }
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