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

package com.furydragons.filemanager.commands.secure;

import com.furydragons.filemanager.commands.AsyncResultListener;
import com.furydragons.filemanager.commands.ChangeOwnerExecutable;
import com.furydragons.filemanager.commands.ChangePermissionsExecutable;
import com.furydragons.filemanager.commands.ChecksumExecutable;
import com.furydragons.filemanager.commands.CompressExecutable;
import com.furydragons.filemanager.commands.ConcurrentAsyncResultListener;
import com.furydragons.filemanager.commands.CopyExecutable;
import com.furydragons.filemanager.commands.CreateDirExecutable;
import com.furydragons.filemanager.commands.CreateFileExecutable;
import com.furydragons.filemanager.commands.DeleteDirExecutable;
import com.furydragons.filemanager.commands.DeleteFileExecutable;
import com.furydragons.filemanager.commands.DiskUsageExecutable;
import com.furydragons.filemanager.commands.EchoExecutable;
import com.furydragons.filemanager.commands.ExecExecutable;
import com.furydragons.filemanager.commands.ExecutableCreator;
import com.furydragons.filemanager.commands.FindExecutable;
import com.furydragons.filemanager.commands.FolderUsageExecutable;
import com.furydragons.filemanager.commands.GroupsExecutable;
import com.furydragons.filemanager.commands.IdentityExecutable;
import com.furydragons.filemanager.commands.LinkExecutable;
import com.furydragons.filemanager.commands.ListExecutable;
import com.furydragons.filemanager.commands.MountExecutable;
import com.furydragons.filemanager.commands.MountPointInfoExecutable;
import com.furydragons.filemanager.commands.MoveExecutable;
import com.furydragons.filemanager.commands.ParentDirExecutable;
import com.furydragons.filemanager.commands.ProcessIdExecutable;
import com.furydragons.filemanager.commands.QuickFolderSearchExecutable;
import com.furydragons.filemanager.commands.ReadExecutable;
import com.furydragons.filemanager.commands.ResolveLinkExecutable;
import com.furydragons.filemanager.commands.SIGNAL;
import com.furydragons.filemanager.commands.SendSignalExecutable;
import com.furydragons.filemanager.commands.UncompressExecutable;
import com.furydragons.filemanager.commands.WriteExecutable;
import com.furydragons.filemanager.commands.ListExecutable.LIST_MODE;
import com.furydragons.filemanager.console.CommandNotFoundException;
import com.furydragons.filemanager.console.secure.SecureConsole;
import com.furydragons.filemanager.model.Group;
import com.furydragons.filemanager.model.MountPoint;
import com.furydragons.filemanager.model.Permissions;
import com.furydragons.filemanager.model.Query;
import com.furydragons.filemanager.model.User;
import com.furydragons.filemanager.preferences.CompressionMode;

/**
 * A class for create shell {@link "Executable"} objects.
 */
public class SecureExecutableCreator implements ExecutableCreator {

    private final SecureConsole mConsole;

    /**
     * Constructor of <code>SecureExecutableCreator</code>.
     *
     * @param console A shell console that use for create objects
     */
    SecureExecutableCreator(SecureConsole console) {
        super();
        this.mConsole = console;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChangeOwnerExecutable createChangeOwnerExecutable(
            String fso, User newUser, Group newGroup) throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChangePermissionsExecutable createChangePermissionsExecutable(
            String fso, Permissions newPermissions) throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CopyExecutable createCopyExecutable(String src, String dst)
            throws CommandNotFoundException {
        return new CopyCommand(mConsole, src, dst);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CreateDirExecutable createCreateDirectoryExecutable(String dir)
            throws CommandNotFoundException {
        return new CreateDirCommand(mConsole, dir);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CreateFileExecutable createCreateFileExecutable(String file)
            throws CommandNotFoundException {
        return new CreateFileCommand(mConsole, file);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeleteDirExecutable createDeleteDirExecutable(String dir)
            throws CommandNotFoundException {
        return new DeleteDirCommand(mConsole, dir);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeleteFileExecutable createDeleteFileExecutable(String file)
            throws CommandNotFoundException {
        return new DeleteFileCommand(mConsole, file);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DiskUsageExecutable createDiskUsageExecutable() throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DiskUsageExecutable createDiskUsageExecutable(String dir)
            throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EchoExecutable createEchoExecutable(String msg) throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented"); //$NON-NLS-1$
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecExecutable createExecExecutable(
            String cmd, AsyncResultListener asyncResultListener) throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented"); //$NON-NLS-1$
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FindExecutable createFindExecutable(
            String directory, Query query, ConcurrentAsyncResultListener asyncResultListener)
            throws CommandNotFoundException {
        return new FindCommand(mConsole, directory, query, asyncResultListener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FolderUsageExecutable createFolderUsageExecutable(
            String directory, AsyncResultListener asyncResultListener)
            throws CommandNotFoundException {
        return new FolderUsageCommand(mConsole, directory, asyncResultListener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GroupsExecutable createGroupsExecutable() throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IdentityExecutable createIdentityExecutable() throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LinkExecutable createLinkExecutable(String src, String link)
            throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented");
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public ListExecutable createListExecutable(String src)
            throws CommandNotFoundException {
        return new ListCommand(mConsole, src, LIST_MODE.DIRECTORY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListExecutable createFileInfoExecutable(String src, boolean followSymlinks)
            throws CommandNotFoundException {
        return new ListCommand(mConsole, src, LIST_MODE.FILEINFO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MountExecutable createMountExecutable(MountPoint mp, boolean rw)
            throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MountPointInfoExecutable createMountPointInfoExecutable()
            throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MoveExecutable createMoveExecutable(String src, String dst)
            throws CommandNotFoundException {
        return new MoveCommand(mConsole, src, dst);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParentDirExecutable createParentDirExecutable(String fso)
            throws CommandNotFoundException {
        return new ParentDirCommand(mConsole, fso);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProcessIdExecutable createShellProcessIdExecutable() throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProcessIdExecutable createProcessIdExecutable(int pid)
            throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProcessIdExecutable createProcessIdExecutable(int pid, String processName)
            throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuickFolderSearchExecutable createQuickFolderSearchExecutable(String regexp)
            throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReadExecutable createReadExecutable(
            String file, AsyncResultListener asyncResultListener)
            throws CommandNotFoundException {
        return new ReadCommand(mConsole, file, asyncResultListener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResolveLinkExecutable createResolveLinkExecutable(String fso)
            throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SendSignalExecutable createSendSignalExecutable(int process, SIGNAL signal)
            throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SendSignalExecutable createKillExecutable(int process)
            throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WriteExecutable createWriteExecutable(
            String file, AsyncResultListener asyncResultListener)
            throws CommandNotFoundException {
        return new WriteCommand(mConsole, file, asyncResultListener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompressExecutable createCompressExecutable(
            CompressionMode mode, String dst, String[] src,
            AsyncResultListener asyncResultListener)
            throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompressExecutable createCompressExecutable(
            CompressionMode mode, String src,
            AsyncResultListener asyncResultListener)
            throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UncompressExecutable createUncompressExecutable(
            String src, String dst,
            AsyncResultListener asyncResultListener)
            throws CommandNotFoundException {
        throw new CommandNotFoundException("Not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChecksumExecutable createChecksumExecutable(
            String src, AsyncResultListener asyncResultListener)
            throws CommandNotFoundException {
        return new ChecksumCommand(mConsole, src, asyncResultListener);
    }

}
