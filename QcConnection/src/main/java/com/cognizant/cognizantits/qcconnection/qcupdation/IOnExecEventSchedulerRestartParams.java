package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{3120287D-98B1-4D49-9BC5-3324555D8D04}")
public abstract interface IOnExecEventSchedulerRestartParams
  extends IOnExecEventSchedulerActionParams
{
  @DISPID(3)
  @VTID(10)
  public abstract void numberOfRetries(int paramInt);
  
  @DISPID(3)
  @VTID(11)
  public abstract int numberOfRetries();
  
  @DISPID(4)
  @VTID(12)
  public abstract void cleanupTest(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(4)
  @VTID(13)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object cleanupTest();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IOnExecEventSchedulerRestartParams
 * JD-Core Version:    0.7.0.1
 */