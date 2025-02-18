/*
 * Copyright (c) 2020-Present, Okta, Inc.
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
 */
package com.okta.idx.sdk.api.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AuthenticatorEnrollments implements Iterable<AuthenticatorEnrollment> {

    private String type;

    private AuthenticatorEnrollment[] value;

    public String getType() {
        return type;
    }

    public AuthenticatorEnrollment[] getValue() {
        return Arrays.copyOf(this.value, this.value.length);
    }

    public List<AuthenticatorEnrollment> getValues() {
        if (value != null) {
            return Arrays.asList(value);
        }
        return Collections.emptyList();
    }

    public Stream<AuthenticatorEnrollment> stream() {
        if (value == null) {
            return Stream.empty();
        }
        return Arrays.stream(getValue());
    }

    @Override
    public Iterator<AuthenticatorEnrollment> iterator() {
        return stream().iterator();
    }
}
