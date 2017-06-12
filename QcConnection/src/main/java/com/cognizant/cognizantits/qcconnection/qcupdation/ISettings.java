package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{55110A8D-110B-460C-9D28-F8B4BCF3DFF0}")
public abstract interface ISettings
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract void open(String paramString);
  
  @DISPID(2)
  @VTID(8)
  public abstract String value(String paramString);
  
  @DISPID(2)
  @VTID(9)
  public abstract void value(String paramString1, String paramString2);
  
  @DISPID(3)
  @VTID(10)
  public abstract void close();
  
  @DISPID(4)
  @VTID(11)
  public abstract void deleteCategory(String paramString);
  
  @DISPID(5)
  @VTID(12)
  public abstract void deleteValue(String paramString);
  
  @DISPID(6)
  @VTID(13)
  public abstract IList enumItems();
  
  @VTID(13)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object enumItems(int paramInt);
  
  @DISPID(7)
  @VTID(14)
  public abstract void post();
  
  @DISPID(8)
  @VTID(15)
  public abstract void refresh(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ISettings
 * JD-Core Version:    0.7.0.1
 */