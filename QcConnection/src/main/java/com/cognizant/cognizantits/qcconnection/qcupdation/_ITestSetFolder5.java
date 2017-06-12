package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DefaultValue;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.VTID;

@IID("{C7D067FD-11BD-4F3C-B245-1AC60C04414F}")
public abstract interface _ITestSetFolder5
  extends Com4jObject
{
  @VTID(3)
  public abstract void undo();
  
  @VTID(4)
  public abstract boolean modified();
  
  @VTID(5)
  public abstract boolean autoUnlock();
  
  @VTID(6)
  public abstract void autoUnlock(boolean paramBoolean);
  
  @VTID(7)
  public abstract void post(@Optional @DefaultValue("-1") boolean paramBoolean);
  
  @VTID(8)
  public abstract boolean isFieldModified(String paramString, @Optional Object paramObject);
  
  @VTID(9)
  public abstract void undoField(String paramString);
  
  @VTID(10)
  public abstract boolean verifyPutFieldWithErrorOnFail(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation._ITestSetFolder5
 * JD-Core Version:    0.7.0.1
 */