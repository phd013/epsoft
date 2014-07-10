/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
*/

var exec = require('cordova/exec');


var epshow = {
    show:function() {
		alert("show start");
        exec(
			function(msg){
				alert("success:start");
				alert(msg);
				alert("success:stop");
			}, function(msg){
				alert("error:start");
				alert(msg);
				alert("error:stop");
			}, "EpShow", "show", []);
		alert("show stop");
    },
	shortToast:function(val){
		exec(null,null,"EpShow","shortToast",[val]);
	},
	getResult:function(val){
		exec(
			function(msg){
				alert("success:"+msg);
			}
		,null,"EpShow","getResult",[val]);
	},
	startService:function(val){
		exec(
			function(msg){
				alert("success:"+msg);
			}
		,null,"EpShow","startService",[val]);
	},
	stopService:function(val){
		exec(
			function(msg){
				alert("success:"+msg);
			}
		,null,"EpShow","stopService",[val]);
	}

};

module.exports = epshow;
