package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{8937B744-DE14-4E34-9A56-4E9E308B1863}")
public abstract interface IBaseFieldEx
  extends IBaseField
{
  @DISPID(11)
  @VTID(20)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject history();
  
  @DISPID(12)
  @VTID(21)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject attachments();
  
  @DISPID(13)
  @VTID(22)
  public abstract boolean hasAttachment();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBaseFieldEx
 * JD-Core Version:    0.7.0.1
 */