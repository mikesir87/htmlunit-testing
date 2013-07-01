/*
 * File created on Jul 1, 2013
 *
 * Copyright 2008-2013 Virginia Polytechnic Institute and State University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * DESCRIBE THE TYPE HERE.
 *
 * @author developer
 */
@Controller
public class AjaxController {

  @ResponseBody
  @RequestMapping("ajax")
  public String fireMessage(final @RequestParam("wait") Long secondsToWait) {
    try { 
    	Thread.sleep(secondsToWait * 1000); 
    } 
    catch (Exception e) {
    	// Who cares?
    }
    return "success";
  }
  
}
