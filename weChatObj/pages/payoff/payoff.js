// pages/payoff/payoff.js
// 获取app.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    sum:0,
    orderid:null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      sum: options.sum,
      orderid:options.id
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },
  
  payResult: function (e) {
    // wx.request({
    //   url: app.globalData.serveraddr + 'wx/order/payoff?orderid=' + e.target.dataset.id,
    //   success:r=>{
    //     if (r.data > 0) {
    //       console.log("状态成功修改")
    //     }
    //   }
    // });
    wx.navigateTo({
      url: '../payResult/payResult?sum=' + e.target.dataset.sum
    })
    setTimeout(function () {
      wx.reLaunch({
        url: '../login/login',
      })
    }, 3000)
  },
  // //立即付款
  // immediatelyPayOff: function (e) {
  //   wx.showToast({
  //     title: '付款成功',
  //     icon:'success',
  //     success:function(e){
  //       setTimeout(function () {
  //         wx.reLaunch({
  //           url: '../login/login',
  //         })
  //         // wx.navigateBack({
  //         //   delta: 5,
  //         // })
  //       }, 3000)
  //     }
  //   })
  // },

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