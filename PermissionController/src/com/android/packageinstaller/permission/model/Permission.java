/*
 * Copyright (C) 2015 The Android Open Source Project
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

package com.android.packageinstaller.permission.model;

import android.app.AppOpsManager;
import android.content.pm.PackageManager;

public final class Permission {
    private final String mName;
    private final int mAppOp;

    private boolean mGranted;
    private boolean mAppOpAllowed;
    private int mFlags;

    public Permission(String name, boolean granted,
            int appOp, boolean appOpAllowed, int flags) {
        mName = name;
        mGranted = granted;
        mAppOp = appOp;
        mAppOpAllowed = appOpAllowed;
        mFlags = flags;
    }

    public String getName() {
        return mName;
    }

    public int getAppOp() {
        return mAppOp;
    }

    public boolean hasAppOp() {
        return mAppOp != AppOpsManager.OP_NONE;
    }

    public boolean isGranted() {
        return mGranted;
    }

    public void setGranted(boolean mGranted) {
        this.mGranted = mGranted;
    }

    public boolean isAppOpAllowed() {
        return mAppOpAllowed;
    }

    public boolean isUserFixed() {
        return (mFlags & PackageManager.FLAG_PERMISSION_USER_FIXED) != 0;
    }

    public void setUserFixed(boolean userFixed) {
        if (userFixed) {
            mFlags |= PackageManager.FLAG_PERMISSION_USER_FIXED;
        } else {
            mFlags &= ~PackageManager.FLAG_PERMISSION_USER_FIXED;
        }
    }

    public boolean isPolicyFixed() {
        return (mFlags & PackageManager.FLAG_PERMISSION_POLICY_FIXED) != 0;
    }

    public boolean isUserSet() {
        return (mFlags & PackageManager.FLAG_PERMISSION_USER_SET) != 0;
    }

    public void setUserSet(boolean userSet) {
        if (userSet) {
            mFlags |= PackageManager.FLAG_PERMISSION_USER_SET;
        } else {
            mFlags &= ~PackageManager.FLAG_PERMISSION_USER_SET;
        }
    }

    public boolean shouldRevokeOnUpgrade() {
        return (mFlags & PackageManager.FLAG_PERMISSION_REVOKE_ON_UPGRADE) != 0;
    }

    public void setRevokeOnUpgrade(boolean revokeOnUpgrade) {
        if (revokeOnUpgrade) {
            mFlags |= PackageManager.FLAG_PERMISSION_REVOKE_ON_UPGRADE;
        } else {
            mFlags &= ~PackageManager.FLAG_PERMISSION_REVOKE_ON_UPGRADE;
        }
    }

    public void setAppOpAllowed(boolean mAppOpAllowed) {
        this.mAppOpAllowed = mAppOpAllowed;
    }
}