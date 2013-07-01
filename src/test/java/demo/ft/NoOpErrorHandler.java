/*
 * File created on May 7, 2013
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

package demo.ft;

import org.w3c.css.sac.CSSException;
import org.w3c.css.sac.CSSParseException;
import org.w3c.css.sac.ErrorHandler;

/**
 * A CSS error handler that does nothing at all.
 *
 * @author ceharris
 */
public class NoOpErrorHandler implements ErrorHandler {

  /**
   * {@inheritDoc}
   */
  @Override
  public void error(CSSParseException ex) throws CSSException {
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void fatalError(CSSParseException ex) throws CSSException {
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void warning(CSSParseException arg0) throws CSSException {
  }

}
