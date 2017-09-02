/*
 * Copyright (C) 2012 The CyanogenMod Project 
	               2017 The FuryDragons Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.furydragons.filemanager.commands.shell;

import com.furydragons.filemanager.commands.ChangePermissionsExecutable;
import com.furydragons.filemanager.console.CommandNotFoundException;
import com.furydragons.filemanager.console.ExecutionException;
import com.furydragons.filemanager.console.InsufficientPermissionsException;
import com.furydragons.filemanager.model.MountPoint;
import com.furydragons.filemanager.model.Permissions;
import com.furydragons.filemanager.util.MountPointHelper;

import java.text.ParseException;


/**
 * A class for change the permissions of an object.
 *
 * {@link "http://unixhelp.ed.ac.uk/CGI/man-cgi?chmod"}
 */
public class ChangePermissionsCommand
    extends SyncResultProgram implements ChangePermissionsExecutable {

    private static final String ID = "chmod";  //$NON-NLS-1$
    private Boolean mRet;
    private final String mFileName;

    /**
     * Constructor of <code>ChangePermissionsCommand</code>.
     *
     * @param fileName The name of the file or directory to be moved
     * @param newPermissions The new permissions to apply to the object
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public ChangePermissionsCommand(
            String fileName, Permissions newPermissions) throws InvalidCommandDefinitionException {
        super(ID, newPermissions.toOctalString(), fileName);
        this.mFileName = fileName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void parse(String in, String err) throws ParseException {
        //Release the return object
        this.mRet = Boolean.TRUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getResult() {
        return this.mRet;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void checkExitCode(int exitCode)
            throws InsufficientPermissionsException, CommandNotFoundException, ExecutionException {
        if (exitCode != 0) {
            throw new ExecutionException("exitcode != 0"); //$NON-NLS-1$
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MountPoint getSrcWritableMountPoint() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MountPoint getDstWritableMountPoint() {
        return MountPointHelper.getMountPointFromDirectory(this.mFileName);
    }
}
