package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{CBD80CD0-1961-4191-A318-ABC50AB2ACD9}")
public abstract interface IOnExecEventSchedulerActionParams
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int onExecEventSchedulerAction();
  
  @DISPID(2)
  @VTID(8)
  public abstract void parameter(int paramInt, @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(2)
  @VTID(9)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object parameter(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IOnExecEventSchedulerActionParams
 * JD-Core Version:    0.7.0.1
 */