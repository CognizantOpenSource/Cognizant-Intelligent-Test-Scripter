package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{0F500A37-F2F1-4079-9BE7-48C1DA715E27}")
public abstract interface ISubjectNode
  extends ISysTreeNode
{
  @DISPID(15)
  @VTID(23)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject testFactory();
  
  @DISPID(16)
  @VTID(24)
  public abstract void removeSubjectNode(@MarshalAs(NativeType.VARIANT) Object paramObject, @Optional @DefaultValue("0") boolean paramBoolean);
  
  @DISPID(17)
  @VTID(25)
  public abstract String description();
  
  @DISPID(17)
  @VTID(26)
  public abstract void description(String paramString);
  
  @DISPID(18)
  @VTID(27)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject attachments();
  
  @DISPID(19)
  @VTID(28)
  public abstract IList findTests(String paramString1, @Optional @DefaultValue("0") boolean paramBoolean, @Optional @DefaultValue("") String paramString2);
  
  @DISPID(20)
  @VTID(29)
  public abstract int viewOrder();
  
  @DISPID(20)
  @VTID(30)
  public abstract void viewOrder(int paramInt);
  
  @DISPID(21)
  @VTID(31)
  public abstract boolean hasAttachment();
  
  @DISPID(22)
  @VTID(32)
  public abstract void move(@MarshalAs(NativeType.VARIANT) Object paramObject);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ISubjectNode
 * JD-Core Version:    0.7.0.1
 */