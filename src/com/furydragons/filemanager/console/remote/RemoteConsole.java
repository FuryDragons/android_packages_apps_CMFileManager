/*
 * Copyright (C) 2014 The CyanogenMod Project 
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


package com.furydragons.filemanager.console.remote;

import android.content.Context;

import com.furydragons.filemanager.commands.Executable;
import com.furydragons.filemanager.commands.ExecutableFactory;
import com.furydragons.filemanager.console.CommandNotFoundException;
import com.furydragons.filemanager.console.ConsoleAllocException;
import com.furydragons.filemanager.console.ExecutionException;
import com.furydragons.filemanager.console.InsufficientPermissionsException;
import com.furydragons.filemanager.console.NoSuchFileOrDirectory;
import com.furydragons.filemanager.console.OperationTimeoutException;
import com.furydragons.filemanager.console.ReadOnlyFilesystemException;
import com.furydragons.filemanager.console.VirtualMountPointConsole;
import com.furydragons.filemanager.model.DiskUsage;
import com.furydragons.filemanager.model.MountPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of a {@link VirtualMountPointConsole} for remote filesystems
 */
public class RemoteConsole extends VirtualMountPointConsole {

    /**
     * Constructor of <code>RemoteConsole</code>
     *
     * @param ctx The current context
     */
    public RemoteConsole(Context ctx) {
        super(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Remote";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSecure() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isRemote() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMounted() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean unmount() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MountPoint> getMountPoints() {
        List<MountPoint> mountPoints = new ArrayList<MountPoint>();
        return mountPoints;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DiskUsage> getDiskUsage() {
        List<DiskUsage> diskUsage = new ArrayList<DiskUsage>();
        return diskUsage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DiskUsage getDiskUsage(String path) {
        // TODO Fix when remote console will be implemented
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMountPointName() {
        return "remote";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableFactory getExecutableFactory() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void execute(Executable executable, Context ctx)
            throws ConsoleAllocException, InsufficientPermissionsException, NoSuchFileOrDirectory,
            OperationTimeoutException, ExecutionException, CommandNotFoundException,
            ReadOnlyFilesystemException {

    }
}
