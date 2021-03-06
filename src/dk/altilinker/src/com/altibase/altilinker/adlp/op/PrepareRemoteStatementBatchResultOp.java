/** 
 *  Copyright (c) 1999~2017, Altibase Corp. and/or its affiliates. All rights reserved.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License, version 3,
 *  as published by the Free Software Foundation.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
 
package com.altibase.altilinker.adlp.op;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

import com.altibase.altilinker.adlp.*;

public class PrepareRemoteStatementBatchResultOp extends ResultOperation
{
    public long  mRemoteStatementId   = 0;
    public short mRemoteNodeSessionId = 0;
    
    public PrepareRemoteStatementBatchResultOp()
    {
        super(OpId.PrepareRemoteStatementBatchResult, true);
    }
    
    protected boolean writeOperation(CommonHeader aCommonHeader,
                                     ByteBuffer   aOpPayload)
    {
        fillCommonHeader(aCommonHeader);
        
        try
        {
            if (canWriteData() == true)
            {
                // write data
                writeLong (aOpPayload, mRemoteStatementId);
                writeShort(aOpPayload, mRemoteNodeSessionId);
            }
        }
        catch (BufferUnderflowException e)
        {
            return false;
        }

        return true;
    }
}
