package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.VTID;

@IID("{328737D2-7777-4E5E-BB9A-488277C730C5}")
public abstract interface ITextParser
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int count();
  
  @DISPID(2)
  @VTID(8)
  public abstract String paramValue(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(2)
  @VTID(9)
  public abstract void paramValue(@MarshalAs(NativeType.VARIANT) Object paramObject, String paramString);
  
  @DISPID(3)
  @VTID(10)
  public abstract void clearParam(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(4)
  @VTID(11)
  public abstract int type(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(5)
  @VTID(12)
  public abstract String paramType(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(6)
  @VTID(13)
  public abstract boolean paramExist(String paramString);
  
  @DISPID(7)
  @VTID(14)
  public abstract String paramName(int paramInt);
  
  @DISPID(8)
  @VTID(15)
  public abstract void initialize(@Optional @DefaultValue("<%") String paramString1, @Optional @DefaultValue("%>") String paramString2, @Optional @DefaultValue("?") String paramString3, @Optional @DefaultValue("-1") int paramInt, @Optional @DefaultValue("string") String paramString4);
  
  @DISPID(9)
  @VTID(16)
  public abstract void text(String paramString);
  
  @DISPID(9)
  @VTID(17)
  public abstract String text();
  
  @DISPID(10)
  @VTID(18)
  public abstract void evaluateText();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITextParser
 * JD-Core Version:    0.7.0.1
 */