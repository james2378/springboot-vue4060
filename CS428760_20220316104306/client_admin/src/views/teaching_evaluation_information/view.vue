<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','semester') || $check_field('add','semester') || $check_field('set','semester')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="学期" prop="semester">
					<el-input id="semester" v-model="form['semester']" placeholder="请输入学期"
							  v-if="user_group === '管理员' || (form['teaching_evaluation_information_id'] && $check_field('set','semester')) || (!form['teaching_evaluation_information_id'] && $check_field('add','semester'))" :disabled="disabledObj['semester_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','semester')">{{form['semester']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','department') || $check_field('add','department') || $check_field('set','department')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="所在院系" prop="department">
					<el-input id="department" v-model="form['department']" placeholder="请输入所在院系"
							  v-if="user_group === '管理员' || (form['teaching_evaluation_information_id'] && $check_field('set','department')) || (!form['teaching_evaluation_information_id'] && $check_field('add','department'))" :disabled="disabledObj['department_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','department')">{{form['department']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','teacher') || $check_field('add','teacher') || $check_field('set','teacher')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="任课教师" prop="teacher">
					<el-input id="teacher" v-model="form['teacher']" placeholder="请输入任课教师"
							  v-if="user_group === '管理员' || (form['teaching_evaluation_information_id'] && $check_field('set','teacher')) || (!form['teaching_evaluation_information_id'] && $check_field('add','teacher'))" :disabled="disabledObj['teacher_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','teacher')">{{form['teacher']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','course_name') || $check_field('add','course_name') || $check_field('set','course_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="课程名称" prop="course_name">
					<el-input id="course_name" v-model="form['course_name']" placeholder="请输入课程名称"
							  v-if="user_group === '管理员' || (form['teaching_evaluation_information_id'] && $check_field('set','course_name')) || (!form['teaching_evaluation_information_id'] && $check_field('add','course_name'))" :disabled="disabledObj['course_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','course_name')">{{form['course_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','course_number') || $check_field('add','course_number') || $check_field('set','course_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="课程编号" prop="course_number">
					<el-input id="course_number" v-model="form['course_number']" placeholder="请输入课程编号"
							  v-if="user_group === '管理员' || (form['teaching_evaluation_information_id'] && $check_field('set','course_number')) || (!form['teaching_evaluation_information_id'] && $check_field('add','course_number'))" :disabled="disabledObj['course_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','course_number')">{{form['course_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "teaching_evaluation_information_id",
				url_add: "~/api/teaching_evaluation_information/add?",
				url_set: "~/api/teaching_evaluation_information/set?",
				url_get_obj: "~/api/teaching_evaluation_information/get_obj?",
				url_upload: "~/api/teaching_evaluation_information/upload?",

				query: {
					"teaching_evaluation_information_id": 0,
				},

				form: {
					"semester":'', // 学期
					"department":'', // 所在院系
					"teacher":'', // 任课教师
					"course_name":'', // 课程名称
					"course_number":'', // 课程编号
					"teaching_evaluation_information_id": 0, // ID

				},
				disabledObj:{
					"semester_isDisabled": false,
					"department_isDisabled": false,
					"teacher_isDisabled": false,
					"course_name_isDisabled": false,
					"course_number_isDisabled": false,
				},
			}
		},
		methods: {

			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
				$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/teaching_evaluation_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/teaching_evaluation_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/teaching_evaluation_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/teaching_evaluation_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/teaching_evaluation_information/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
		},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}
</style>
