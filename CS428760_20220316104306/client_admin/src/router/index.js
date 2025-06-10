import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		name: 'index',
		component: index,
		meta: {
			index: 0,
			title: '首页'
		}
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},

	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},
	// 学生用户路由
	{
		path: '/student_user/table',
		name: 'student_user_table',
		component: () => import('../views/student_user/table.vue')
	},
	{
		path: '/student_user/view',
		name: 'student_user_view',
		component: () => import('../views/student_user/view.vue')
	},
	// 教师用户路由
	{
		path: '/teacher_user/table',
		name: 'teacher_user_table',
		component: () => import('../views/teacher_user/table.vue')
	},
	{
		path: '/teacher_user/view',
		name: 'teacher_user_view',
		component: () => import('../views/teacher_user/view.vue')
	},
	// 评教信息路由
	{
		path: '/teaching_evaluation_information/table',
		name: 'teaching_evaluation_information_table',
		component: () => import('../views/teaching_evaluation_information/table.vue')
	},
	{
		path: '/teaching_evaluation_information/view',
		name: 'teaching_evaluation_information_view',
		component: () => import('../views/teaching_evaluation_information/view.vue')
	},
	// 评价打分路由
	{
		path: '/evaluation_and_scoring/table',
		name: 'evaluation_and_scoring_table',
		component: () => import('../views/evaluation_and_scoring/table.vue')
	},
	{
		path: '/evaluation_and_scoring/view',
		name: 'evaluation_and_scoring_view',
		component: () => import('../views/evaluation_and_scoring/view.vue')
	},
	// 指标管理路由
	{
		path: '/index_management/table',
		name: 'index_management_table',
		component: () => import('../views/index_management/table.vue')
	},
	{
		path: '/index_management/view',
		name: 'index_management_view',
		component: () => import('../views/index_management/view.vue')
	},
	// 课程管理路由
	{
		path: '/course_management/table',
		name: 'course_management_table',
		component: () => import('../views/course_management/table.vue')
	},
	{
		path: '/course_management/view',
		name: 'course_management_view',
		component: () => import('../views/course_management/view.vue')
	},
	// 教师评分统计路由
	{
		path: '/teacher_score_statistics/table',
		name: 'teacher_score_statistics_table',
		component: () => import('../views/teacher_score_statistics/table.vue')
	},
	{
		path: '/teacher_score_statistics/view',
		name: 'teacher_score_statistics_view',
		component: () => import('../views/teacher_score_statistics/view.vue')
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.beforeEach((to, from, next) => {
	let token = to.query.token;
	if (token){
		$.db.set("token",token,120);
	}
	next();
})

router.afterEach((to, from, next) => {
	let title = "高校学生评教系统-admin";
	document.title = title;
})

export default router
