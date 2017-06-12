package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DefaultValue;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{E9E2BCFE-CAAC-492D-A210-C2E49A68C78F}")
public abstract interface ITestSetFolder
  extends ISysTreeNode
{
  @VTID(23)
  public abstract String description();
  
  @VTID(24)
  public abstract void description(String paramString);
  
  @VTID(25)
  public abstract int fatherID();
  
  @VTID(26)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject fatherDisp();
  
  @VTID(27)
  public abstract int viewOrder();
  
  @VTID(28)
  public abstract void viewOrder(int paramInt);
  
  @VTID(29)
  public abstract IList subNodes();
  
  @VTID(29)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object subNodes(int paramInt);
  
  @VTID(30)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addNodeDisp(String paramString);
  
  @VTID(31)
  public abstract void removeNodeEx(@MarshalAs(NativeType.VARIANT) Object paramObject, @Optional @DefaultValue("0") boolean paramBoolean);
  
  @VTID(32)
  public abstract void move(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @VTID(33)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject testSetFactory();
  
  @VTID(34)
  public abstract boolean hasAttachment();
  
  @VTID(35)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject attachments();
  
  @VTID(36)
  public abstract IList findTestSets(String paramString1, @Optional @DefaultValue("0") boolean paramBoolean, @Optional @DefaultValue("") String paramString2);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITestSetFolder
 * JD-Core Version:    0.7.0.1
 */