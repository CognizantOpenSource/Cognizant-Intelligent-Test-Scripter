package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.Holder;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{C691D4B4-3924-4488-B554-A7E08842C625}")
public abstract interface IAttachmentFactory
  extends IBaseFactory
{
  @DISPID(8)
  @VTID(16)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject attachmentStorage();
  
  @DISPID(9)
  @VTID(17)
  public abstract void factoryProperties(Holder<String> paramHolder, Object paramObject);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAttachmentFactory
 * JD-Core Version:    0.7.0.1
 */