<template>
	<div class="flex-col page">
	  <div class="flex-col items-start group">
		<div class="section_2"></div>
		<span class="text">大小写转换</span>
		<img
		  class="image"
		  src="https://codefun-proj-user-res-1256085488.cos.ap-guangzhou.myqcloud.com/635c9b255a7e3f031085335e/635c9b51fe65f70012e6634b/16688385694568411170.png"
		/>
		<div class="flex-col items-start text-wrapper"   style="height: 0rem;"><input class="text_2" placeholder="请输入需要转换的数字" style="width: 90%;border: none;background-color: #f5f9fa;outline: none;" maxlength="11" v-model="form.num">
		
		   
		   </div>
  <!--   
		<span class="font_1 text_3" >输入</span> -->
			   
			  <div>
				<div class="flex-row group view_2 space-x-37">
						 
				  <div class="flex-col group_2" >
	 <span style="margin-left: 43rem;background-color: red;top: 2rem;width: 8rem;height: 2.69rem; text-align: center;line-height: 2.5rem;border-radius: 1.25rem;background-color: #e56352;color: #ffffff;font-size: 35px;font-weight: 500;" @click="changenum()">转 换</span>
					<span class="" style=" margin-left:21.78rem;margin-top: 5rem;"></span>
				 
					<div class="section_3" style=" margin-left:21.78rem;width: 28.44rem;margin-top: -3rem;">
					  <span class="res">{{form.res}}</span>
					</div>
				  </div>
				  <img
					class="image_2"
					src="./assets/robot.png"
					style=" margin-left:21.78rem;"
				  />
				</div>
			  </div>
	  </div>
	</div>
  </template>
  
  <script>
  import HelloWorld from './components/HelloWorld.vue'
  import http from '../src/util/http'
   export default {
	name: 'app',
	components: {
	  HelloWorld
	},
	data(){
	  return{
		form:{
		  num:0,
		  res:""
		}
	  }
	},
	methods:{
	  changenum(){
		console.log('1111')
		http({
				  method:'post',
				  url:'/change/'+this.form.num,
				  // data:{
				  //     pageNo: this.pageNo,
				  //     pageSize: this.pageSize,
				  // }
			  }).then(res=>{
				  this.form.res=res.data
			  })
	  
	  }
	}
  }
  </script>
  
  <style>
  ::-webkit-input-placeholder{/*Webkit browsers*/
	  color:#999;
	  font-size:25px;
  }
  .res{
	width: 455px;
	font-size:25px;
	font-weight: bold;
  }
  .font_1 {
	font-size: 1.13rem;
	font-family: SourceHanSansCN;
	line-height: 1.03rem;
	color: #383838;
  }
  .group {
	position: relative;
  }
  .page {
	padding-left: 9rem;
	padding-top: 9.38rem;
	background-color: #ffffff;
	background-image: url('./assets/bg.jpg');
	opacity: 98%;
	background-position: 0% 0%;
	background-size: 100% 100%;
	background-repeat: no-repeat;
	height: 100%;
	width: 100%;
	overflow-y: auto;
	overflow-x: hidden;
  }
  .view_2 {
	margin: -21.5rem 0 -9.38rem;
	align-self: flex-end;
  }
  .section_2 {
	opacity: 0.8;
	background-color: #ffffff;
	border-radius: 0.94rem;
	box-shadow: 0px 0px 0.25rem #f0f4f5;
	width: 71.94rem;
	height: 43.25rem;
	border: solid 0.063rem #f4f5f9;
	position: relative;
  }
  .text {
	color: #e66453;
	font-size: 5rem;
	font-weight: bold;
	font-family: HappyZcool;
	line-height: 3.84rem;
	position: absolute;
	left: 25.19rem;
	top: 4.19rem;
  }
  .image {
	width: 8.25rem;
	height: 8.31rem;
	position: absolute;
	left: 3.28rem;
	top: 2.44rem;
  }
  .text-wrapper {
	padding: 0.88rem 0 8.5rem;
	background-color: #f5f9fa;
	border-radius: 0.31rem;
	box-shadow: 0px 0px 0.5rem 0.19rem #00000040;
	width: 28.44rem;
	position: absolute;
	left: 21.78rem;
	top: 13.38rem;
  }
  .text_3 {
	position: absolute;
	left: 21.84rem;
	top: 11.66rem;
  }
  .group_2 {
	margin-top: 2.06rem;
	flex: 1 1 28.47rem;
	width: 28.44rem;
  }
  .image_2 {
	flex: 1 1 28.47rem;
	width: 28.44rem;
	height: 40.25rem;
  }
  .text_2 {
	margin-left: 1.13rem;
	color: #a6a6a6;
	font-size: 1rem;
	font-family: SourceHanSansCN;
	line-height: 0.94rem;
  }
  .text-wrapper_2 {
	margin-right: 0.81rem;
	padding: 0.63rem 0;
	align-self: flex-end;
	background-color: #e56352;
	border-radius: 1.25rem;
	box-shadow: 0px 0px 0.19rem 0.19rem #00000040;
	width: 5.69rem;
  }
  .text_5 {
	margin-top: 0.38rem;
	align-self: flex-start;
  }
  .section_3 {
	margin-top: 0.88rem;
	background-color: #f5f9fa;
	border-radius: 0.31rem;
	box-shadow: 0px 0px 0.5rem 0.19rem #00000040;
	height: 10.31rem;
  }
  .text_4 {
	color: #ffffff;
  }
  .space-x-37 > *:not(:first-child) {
	margin-left: 2.31rem;
  }
  /************************************************************
  ** 请将全局样式拷贝到项目的全局 CSS 文件或者当前页面的顶部 **
  ** 否则页面将无法正常显示                                  **
  ************************************************************/
  
  html {
	font-size: 20px;
  }
  
  body {
	margin: 0;
	font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen', 'Ubuntu', 'Cantarell', 'Fira Sans',
	  'Droid Sans', 'Helvetica Neue', 'Microsoft Yahei', sans-serif;
  }
  
  body * {
	box-sizing: border-box;
	flex-shrink: 0;
  }
  
  #app {
	width: 100vw;
	height: 100vh;
  }
  
  .flex-row {
	display: flex;
	flex-direction: row;
  }
  
  .flex-col {
	display: flex;
	flex-direction: column;
  }
  
  .justify-start {
	justify-content: flex-start;
  }
  
  .justify-center {
	justify-content: center;
  }
  
  .justify-end {
	justify-content: flex-end;
  }
  
  .justify-evenly {
	justify-content: space-evenly;
  }
  
  .justify-around {
	justify-content: space-around;
  }
  
  .justify-between {
	justify-content: space-between;
  }
  
  .items-start {
	align-items: flex-start;
  }
  
  .items-center {
	align-items: center;
  }
  
  .items-end {
	align-items: flex-end;
  }
  </style>
  