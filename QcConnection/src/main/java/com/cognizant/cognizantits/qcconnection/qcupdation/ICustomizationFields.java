package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{6388B1FB-C735-4D24-B1E4-97221B302461}")
public abstract interface ICustomizationFields
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject field(String paramString1, String paramString2);
  
  @DISPID(2)
  @VTID(8)
  public abstract IList fields(@Optional @DefaultValue("") String paramString);
  
  @DISPID(3)
  @VTID(9)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addActiveField(String paramString);
  
  @DISPID(4)
  @VTID(10)
  public abstract boolean fieldExists(String paramString1, String paramString2);
  
  @DISPID(5)
  @VTID(11)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addActiveMemoField(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationFields
 * JD-Core Version:    0.7.0.1
 */