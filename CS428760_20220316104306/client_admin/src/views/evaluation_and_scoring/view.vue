<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','student') || $check_field('add','student') || $check_field('set','student')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="学生" prop="student">
						<div v-if="user_group !== '管理员'">
							{{ get_user_session_student(form['student']) }}
							<!--<el-input id="business_name" v-model="form['student']" placeholder="请输入学生"-->
							<!--v-if="user_group === '管理员' || (form['evaluation_and_scoring_id'] && $check_field('set','student')) || (!form['evaluation_and_scoring_id'] && $check_field('add','student'))" :disabled="disabledObj['student_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','student')">{{form['student']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['evaluation_and_scoring_id'] && $check_field('set','student')) || (!form['evaluation_and_scoring_id'] && $check_field('add','student'))" id="student" v-model="form['student']" :disabled="disabledObj['student_isDisabled']">
								<el-option v-for="o in list_user_student" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','student')" id="student" v-model="form['student']" :disabled="true">
								<el-option v-for="o in list_user_student" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="student" v-model="form['student']" :disabled="disabledObj['student_isDisabled']">
							<el-option v-for="o in list_user_student" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','full_name') || $check_field('add','full_name') || $check_field('set','full_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="姓名" prop="full_name">
					<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"
							  v-if="user_group === '管理员' || (form['evaluation_and_scoring_id'] && $check_field('set','full_name')) || (!form['evaluation_and_scoring_id'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','full_name')">{{form['full_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','major') || $check_field('add','major') || $check_field('set','major')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="专业" prop="major">
					<el-input id="major" v-model="form['major']" placeholder="请输入专业"
							  v-if="user_group === '管理员' || (form['evaluation_and_scoring_id'] && $check_field('set','major')) || (!form['evaluation_and_scoring_id'] && $check_field('add','major'))" :disabled="disabledObj['major_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','major')">{{form['major']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','semester') || $check_field('add','semester') || $check_field('set','semester')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="学期" prop="semester">
					<el-input id="semester" v-model="form['semester']" placeholder="请输入学期"
							  v-if="user_group === '管理员' || (form['evaluation_and_scoring_id'] && $check_field('set','semester')) || (!form['evaluation_and_scoring_id'] && $check_field('add','semester'))" :disabled="disabledObj['semester_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','semester')">{{form['semester']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','department') || $check_field('add','department') || $check_field('set','department')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="所在院系" prop="department">
					<el-input id="department" v-model="form['department']" placeholder="请输入所在院系"
							  v-if="user_group === '管理员' || (form['evaluation_and_scoring_id'] && $check_field('set','department')) || (!form['evaluation_and_scoring_id'] && $check_field('add','department'))" :disabled="disabledObj['department_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','department')">{{form['department']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','course_number') || $check_field('add','course_number') || $check_field('set','course_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="课程编号" prop="course_number">
					<el-input id="course_number" v-model="form['course_number']" placeholder="请输入课程编号"
							  v-if="user_group === '管理员' || (form['evaluation_and_scoring_id'] && $check_field('set','course_number')) || (!form['evaluation_and_scoring_id'] && $check_field('add','course_number'))" :disabled="disabledObj['course_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','course_number')">{{form['course_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','course_name') || $check_field('add','course_name') || $check_field('set','course_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="课程名称" prop="course_name">
					<el-input id="course_name" v-model="form['course_name']" placeholder="请输入课程名称"
							  v-if="user_group === '管理员' || (form['evaluation_and_scoring_id'] && $check_field('set','course_name')) || (!form['evaluation_and_scoring_id'] && $check_field('add','course_name'))" :disabled="disabledObj['course_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','course_name')">{{form['course_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','teacher') || $check_field('add','teacher') || $check_field('set','teacher')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="任课教师" prop="teacher">
					<el-input id="teacher" v-model="form['teacher']" placeholder="请输入任课教师"
							  v-if="user_group === '管理员' || (form['evaluation_and_scoring_id'] && $check_field('set','teacher')) || (!form['evaluation_and_scoring_id'] && $check_field('add','teacher'))" :disabled="disabledObj['teacher_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','teacher')">{{form['teacher']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','student_evaluation') || $check_field('add','student_evaluation') || $check_field('set','student_evaluation')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="学生评价" prop="student_evaluation">
					<el-input id="student_evaluation" v-model="form['student_evaluation']" placeholder="请输入学生评价"
							  v-if="user_group === '管理员' || (form['evaluation_and_scoring_id'] && $check_field('set','student_evaluation')) || (!form['evaluation_and_scoring_id'] && $check_field('add','student_evaluation'))" :disabled="disabledObj['student_evaluation_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','student_evaluation')">{{form['student_evaluation']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','student_scoring') || $check_field('add','student_scoring') || $check_field('set','student_scoring')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="学生打分" prop="student_scoring">
					<el-input id="student_scoring" v-model="form['student_scoring']" placeholder="请输入学生打分"
							  v-if="user_group === '管理员' || (form['evaluation_and_scoring_id'] && $check_field('set','student_scoring')) || (!form['evaluation_and_scoring_id'] && $check_field('add','student_scoring'))" :disabled="disabledObj['student_scoring_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','student_scoring')">{{form['student_scoring']}}</div>
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
				field: "evaluation_and_scoring_id",
				url_add: "~/api/evaluation_and_scoring/add?",
				url_set: "~/api/evaluation_and_scoring/set?",
				url_get_obj: "~/api/evaluation_and_scoring/get_obj?",
				url_upload: "~/api/evaluation_and_scoring/upload?",

				query: {
					"evaluation_and_scoring_id": 0,
				},

				form: {
					"student": 0, // 学生
					"full_name":'', // 姓名
					"major":'', // 专业
					"semester":'', // 学期
					"department":'', // 所在院系
					"course_number":'', // 课程编号
					"course_name":'', // 课程名称
					"teacher":'', // 任课教师
					"student_evaluation":'', // 学生评价
					"student_scoring":'', // 学生打分
					"evaluation_and_scoring_id": 0, // ID

				},
				disabledObj:{
					"student_isDisabled": false,
					"full_name_isDisabled": false,
					"major_isDisabled": false,
					"semester_isDisabled": false,
					"department_isDisabled": false,
					"course_number_isDisabled": false,
					"course_name_isDisabled": false,
					"teacher_isDisabled": false,
					"student_evaluation_isDisabled": false,
					"student_scoring_isDisabled": false,
				},
				// 用户列表
				list_user_student: [],
				// 用户组
				group_user_student: "",
			}
		},
		methods: {
			/**
			 * 获取学生用户用户列表
			 */
			async get_list_user_student() {
                // if(this.user_group !== "管理员" && this.form["student"] === 0) {
                //     this.form["student"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=学生用户");
                if(json.result && json.result.list){
                    this.list_user_student = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
			/**
			 * 获取学生用户用户组
			 */
			async get_group_user_student() {
				this.form["student"] = this.user.user_id;
				var json = await this.$get("~/api/user_group/get_obj?name=学生用户");
				if(json.result && json.result.obj){
					this.group_user_student = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_student(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_student.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
						for (let key in _this.form) {
							arrForm.push(key)
						}
						for (var i=0;i<arr.length;i++){
							for (var j=0;j<arrForm.length;j++){
								if (arr[i]===arrForm[j]){
									if (arr[i]!=="student") {
										_this.form[arrForm[j]] = res.result.obj[arr[i]]
										_this.disabledObj[arrForm[j] + '_isDisabled'] = true
										break;
									}else {
										_this.disabledObj[arrForm[j] + '_isDisabled'] = true
									}
								}
							}
						}
					}
				});
			},
			get_user_student(id){
				var obj = this.list_user_student.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},

			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
				// 获取缓存数据附加
				form = $.db.get("form");
				$.push(this.form ,form);
				/**
				* 请求列表前
				* @param {Object} param
				*/
				var user_group = this.user.user_group;
				if (user_group !== "管理员") {
					switch (user_group) {
						case "学生":
							if(param["student"] > 0){
								param["student"] = this.user.user_id;
							}
							break;
					}
				}
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
					bl = this.$check_action('/evaluation_and_scoring/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/evaluation_and_scoring/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/evaluation_and_scoring/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/evaluation_and_scoring/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/evaluation_and_scoring/view','get');
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
			this.get_list_user_student();
			this.get_group_user_student();
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
