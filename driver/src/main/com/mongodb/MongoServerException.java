/*
 * Copyright (c) 2008-2014 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mongodb;

/**
 * An exception indicating that some error has been raised by a MongoDB server in response to an operation.
 *
 * @since 3.0
 */
public abstract class MongoServerException extends MongoException {
    private static final long serialVersionUID = -5213859742051776206L;
    private final ServerAddress serverAddress;

    /**
     * Construct a new instance.
     *
     * @param message the message from the server
     * @param serverAddress the address of the server
     */
    public MongoServerException(final String message, final ServerAddress serverAddress) {
        super(message);
        this.serverAddress = serverAddress;
    }

    /**
     * Gets the address of the server.
     *
     * @return the address
     */
    public ServerAddress getServerAddress() {
        return serverAddress;
    }

    /**
     * Gets the error code generated by the server.
     * @return the error code
     */
    public abstract int getErrorCode();

    @Override
    public int getCode() {
        return getErrorCode();
    }

    /**
     * Gets the error message generated by the server.
     *
     * @return the error message.
     */
    public abstract String getErrorMessage();
}
