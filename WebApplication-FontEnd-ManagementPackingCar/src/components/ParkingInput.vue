<template>
  <div class="form-group" :class="col ? `col-${col}` : ''">
    <label :for="id" class="form-label" v-if="label">{{label}}</label>
    <input
      :type="type"
      class="form-control"
      :class="getClasses(size, valid)"
      :name="name"
      :id="id"
      :value="modelValue"
      :placeholder="placeholder"
      :isRequired="isRequired"
      @input="updateValue"
      @blur="$emit('blur', $event)"
    />
    <small id="emailHelp" class="form-small text-danger" v-if="valid === false">{{getMessage(message, placeholder)}}</small>
  </div>
</template>

<script>
export default {
  name: "parking-input",
  props: {
    size: {
      type: String,
      default: "default",
    },
    col: {
      type: String,
      default: "",
    },
    valid: {
      type: Boolean,
      default: null,
    },
    label: {
      type: String,
      default: null,
    },
    message: {
      type: String,
      default: '',
    },
    name: String,
    id: String,
    modelValue: String,
    placeholder: String,
    type: String,
    isRequired: Boolean,
  },
  methods: {
    getClasses: (size, valid) => {
      let sizeValue, isValidValue = '';

      sizeValue = size ? `form-control-${size}` : null;

      if (valid === true) {
        isValidValue = 'is-valid';
      } else if (valid === false) {
        isValidValue = 'is-invalid';
      }
      return `${sizeValue} ${isValidValue}`;
    },

    getMessage: (message, placeholder) => {
      return message ? message :  `Invalid  ${placeholder}`;
    },

    updateValue(event) {
      this.$emit('update:modelValue', event.target.value);
    }
  },
};
</script>
<style scoped>
.form-small {
  font-size: small;
}
</style>
