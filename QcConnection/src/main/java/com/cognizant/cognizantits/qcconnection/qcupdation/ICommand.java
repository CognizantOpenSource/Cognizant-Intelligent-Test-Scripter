package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultMethod;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{35DE061D-B934-4DEB-9F53-6A376EB034DF}")
public abstract interface ICommand
  extends IParam
{
  @DISPID(0)
  @VTID(16)
  @DefaultMethod
  public abstract String commandText();
  
  @DISPID(0)
  @VTID(17)
  @DefaultMethod
  public abstract void commandText(String paramString);
  
  @DISPID(9)
  @VTID(18)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject execute();
  
  @DISPID(10)
  @VTID(19)
  public abstract String indexFields();
  
  @DISPID(10)
  @VTID(20)
  public abstract void indexFields(String paramString);
  
  @DISPID(11)
  @VTID(21)
  public abstract int affectedRows();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICommand
 * JD-Core Version:    0.7.0.1
 */