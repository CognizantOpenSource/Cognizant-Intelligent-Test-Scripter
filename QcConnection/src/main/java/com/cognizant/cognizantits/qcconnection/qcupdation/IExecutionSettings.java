package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{41120F91-BBBE-4913-975D-5346234765A6}")
public abstract interface IExecutionSettings
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract void plannedExecutionTime(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(1)
  @VTID(8)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object plannedExecutionTime();
  
  @DISPID(2)
  @VTID(9)
  public abstract void plannedExecutionDate(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(2)
  @VTID(10)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object plannedExecutionDate();
  
  @DISPID(3)
  @VTID(11)
  public abstract void plannedRunDuration(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(3)
  @VTID(12)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object plannedRunDuration();
  
  @DISPID(4)
  @VTID(13)
  public abstract int onExecEventSchedulerActionType(int paramInt);
  
  @DISPID(4)
  @VTID(14)
  public abstract void onExecEventSchedulerActionType(int paramInt1, int paramInt2);
  
  @DISPID(5)
  @VTID(15)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject onExecEventSchedulerActionParams(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IExecutionSettings
 * JD-Core Version:    0.7.0.1
 */