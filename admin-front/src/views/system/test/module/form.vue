<template>
  <el-dialog :append-to-body="true" :visible.sync="dialog" :title="isAdd ? '新增' : '编辑'" width="500px">
    <el-form ref="form" :model="form" :rules="rules" size="small" label-width="80px">
      <el-form-item label="测试列1">
        <el-input v-model="form.col1" style="width: 370px;"/>
      </el-form-item>
      <el-form-item label="测试列2">
        <el-input v-model="form.col2" style="width: 370px;"/>
      </el-form-item>
      <el-form-item label="测试列3">
        <el-input v-model="form.col3" style="width: 370px;"/>
      </el-form-item>
      <el-form-item label="测试列4">
        <el-input v-model="form.col4" style="width: 370px;"/>
      </el-form-item>
      <el-form-item label="测试列5">
        <el-input v-model="form.col5" style="width: 370px;"/>
      </el-form-item>
      <el-form-item label="测试列6">
        <el-input v-model="form.col6" style="width: 370px;"/>
      </el-form-item>
      <el-form-item label="测试列7">
        <el-input v-model="form.col7" style="width: 370px;"/>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button type="text" @click="cancel">取消</el-button>
      <el-button :loading="loading" type="primary" @click="doSubmit">确认</el-button>
    </div>
  </el-dialog>
</template>

<script>
import { add, edit } from '@/api/test'
export default {
  props: {
    isAdd: {
      type: Boolean,
      required: true
    },
    sup_this: {
      type: Object,
      default: null
    }
  },
  data() {
    return {
      loading: false, dialog: false,
      form: {
        id: '',
        col1: '',
        col2: '',
        col3: '',
        col4: '',
        col5: '',
        col6: '',
        col7: ''
      }
    }
  },
  methods: {
    cancel() {
      this.resetForm()
    },
    doSubmit() {
      this.loading = true
      if (this.isAdd) {
        this.doAdd()
      } else this.doEdit()
    },
    doAdd() {
      add(this.form).then(res => {
        this.resetForm()
        this.$notify({
          title: '添加成功',
          type: 'success',
          duration: 2500
        })
        this.loading = false
        this.$parent.$parent.init()
      }).catch(err => {
        this.loading = false
        console.log(err.response.data.message)
      })
    },
    doEdit() {
      edit(this.form).then(res => {
        this.resetForm()
        this.$notify({
          title: '修改成功',
          type: 'success',
          duration: 2500
        })
        this.loading = false
        this.sup_this.init()
      }).catch(err => {
        this.loading = false
        console.log(err.response.data.message)
      })
    },
    resetForm() {
      this.dialog = false
      this.$refs['form'].resetFields()
      this.form = {
        id: '',
        col1: '',
        col2: '',
        col3: '',
        col4: '',
        col5: '',
        col6: '',
        col7: ''
      }
    }
  }
}
</script>

<style scoped>

</style>
