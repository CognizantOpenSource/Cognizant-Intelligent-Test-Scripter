package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.Holder;
import com4j.IID;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{F3D168E0-A5FD-4083-ADDF-1E64EE968E59}")
public abstract interface ICommand2
  extends ICommand
{
  @DISPID(12)
  @VTID(22)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject executeQuery(int paramInt, Holder<Integer> paramHolder, @Optional @DefaultValue("0") boolean paramBoolean);
  
  @DISPID(13)
  @VTID(23)
  public abstract void cancel();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICommand2
 * JD-Core Version:    0.7.0.1
 */