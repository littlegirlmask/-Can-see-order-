// pages/info/info.js
var app = getApp();

Page({
  /**
   * 组件的属性列表
   */
  properties: {

  },

  /**
   * 组件的初始数据
   */
  data: {
    serveraddr: app.globalData.serveraddr
  },

  /**
   * 组件的方法列表
   */
  methods: {

  },
  onLoad: function (options) {
    console.log(options);
    this.setData({
      gname: options.gname,
      gimg: options.gimg,
      gprice: options.gprice,
      gcontent: options.gcontent
    })
  },



})
