package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultMethod;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;
import java.util.Iterator;

@IID("{D367F107-1BCE-4AAB-8E6B-BF6399BD64FC}")
public abstract interface IExecutionStatus
  extends Com4jObject, Iterable<Com4jObject>
{
  @DISPID(1)
  @VTID(7)
  public abstract int count();
  
  @DISPID(2)
  @VTID(8)
  public abstract void refreshExecStatusInfo(@MarshalAs(NativeType.VARIANT) Object paramObject, boolean paramBoolean);
  
  @DISPID(3)
  @VTID(9)
  public abstract boolean finished();
  
  @DISPID(4)
  @VTID(10)
  public abstract IList eventsList();
  
  @VTID(10)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object eventsList(int paramInt);
  
  @DISPID(0)
  @VTID(11)
  @DefaultMethod
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object item(int paramInt);
  
  @DISPID(-4)
  @VTID(12)
  public abstract Iterator<Com4jObject> iterator();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IExecutionStatus
 * JD-Core Version:    0.7.0.1
 */