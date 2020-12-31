package com.leet.day.dec;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;

/**
 * Created In Ctrip. <br/>
 *
 * @author: yangxia <br/>
 * @date: 2019/8/14 <br/>
 */
public class ValidInfo {

    private boolean isMap = false;
    private Set<String> validList;
    private Set<Integer> stepList;
    private String identityCode;
    private String identityName;
    private String mobile;
    private String email;
    private Map<String, Object> param = Maps.newHashMap();

    public ValidInfo() {
    }

    private ValidInfo(Builder builder) {
        setValidList(builder.validList);
        setStepList(builder.stepList);
        setIdentityCode(builder.identityCode);
        setIdentityName(builder.identityName);
        setMobile(builder.mobile);
        setEmail(builder.email);
        setParam(builder.param);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Set<String> getValidList() {
        return validList;
    }

    public void setValidList(Set<String> validList) {
        this.validList = validList;
    }

    public void addValidList(String... valids) {
        if (this.validList == null) {
            this.validList = Sets.newHashSet(valids);
        } else {
            this.validList.addAll(Sets.newHashSet(valids));
        }
    }

    public Set<Integer> getStepList() {
        return stepList;
    }

    public void setStepList(Set<Integer> stepList) {
        this.stepList = stepList;
    }

    public void addStepList(Integer... steps) {
        if (this.stepList == null) {
            this.stepList = Sets.newHashSet(steps);
        } else {
            this.stepList.addAll(Sets.newHashSet(steps));
        }
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public String getIdentityName() {
        return identityName;
    }

    public void setIdentityName(String identityName) {
        this.identityName = identityName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }

    public void addParam(String key, Object value) {
        if (this.param == null) this.param = Maps.newHashMap();

        this.param.put(key, value);
    }

    public boolean isMap() {
        return isMap;
    }

    public ValidInfo asMap() {
        this.isMap = true;
        return this;
    }

    @Override
    public String toString() {
        return "ValidInfo{" +
                "validList=" + validList +
                ", stepList=" + stepList +
                ", identityCode='" + identityCode + '\'' +
                ", identityName='" + identityName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", param=" + param  +
                '}';
    }

    public static final class Builder {
        private Set<String> validList;
        private Set<Integer> stepList;
        private String identityCode;
        private String identityName;
        private String mobile;
        private String email;
        private Map<String, Object> param = Maps.newHashMap();

        private Builder() {
        }

        public Builder validList(Set<String> val) {
            validList = val;
            return this;
        }

        public Builder stepList(Set<Integer> val) {
            stepList = val;
            return this;
        }

        public Builder validList(String... val) {
            if (validList == null) {
                validList = Sets.newHashSet(val);
            } else {
                validList.addAll(Sets.newHashSet(val));
            }
            return this;
        }

        public Builder stepList(Integer... val) {
            if (stepList == null) {
                stepList = Sets.newHashSet(val);
            } else {
                stepList.addAll(Sets.newHashSet(val));
            }
            return this;
        }

        public Builder identityCode(String val) {
            identityCode = val;
            return this;
        }

        public Builder identityName(String val) {
            identityName = val;
            return this;
        }

        public Builder mobile(String val) {
            mobile = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder param(String key, Object value) {
            if (this.param == null) this.param = Maps.newHashMap();

            this.param.put(key, value);
            return this;
        }

        public ValidInfo build() {
            return new ValidInfo(this);
        }
    }

    public static void main(String[] args) {
        //举例
        ValidInfo password = ValidInfo
                .newBuilder()
                ////以字段 按需填写
                .stepList(1, 2)
                .validList(Sets.newHashSet("password", "face"))
                .validList("checkMobile")
                .identityCode("identityCode")
                .identityName("identityName")
                .mobile("mobile")
                .email("email")
                .param("type", "nonidentity_credit")
                .build();

        //结果： ValidInfo{validList=[password, face, checkMobile], stepList=[1, 2], identityCode='', identityName='', mobile=''}
        System.out.println(password);
    }
}
