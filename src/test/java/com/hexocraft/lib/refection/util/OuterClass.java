package com.hexocraft.lib.refection.util;

/*

 Copyright 2018 hexosse

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

 */
public class OuterClass {

    private int data;
    private String value;

    static class innerClass {

        private String value;

        public innerClass() {
        }

        public innerClass(String value) {
            this.value = value;
        }
    }


    public OuterClass() {
    }

    public OuterClass(String value) {
        this.value = value;
    }

    public OuterClass(int data) {
        this.data = data;
    }

    public OuterClass(int data, String value) {
        this.data = data;
        this.value = value;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setDataValue(int data, String value) {
        this.data = data;
        this.value = value;
    }
}
