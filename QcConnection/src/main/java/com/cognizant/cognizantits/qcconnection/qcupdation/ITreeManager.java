package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultMethod;
import com4j.DefaultValue;
import com4j.IID;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{E60B4439-691C-433D-B6D9-793044915A01}")
public abstract interface ITreeManager
  extends Com4jObject
{
  @DISPID(0)
  @VTID(7)
  @DefaultMethod
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject treeRoot(String paramString);
  
  @DISPID(1)
  @VTID(8)
  public abstract String nodePath(int paramInt);
  
  @DISPID(2)
  @VTID(9)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject nodeByPath(String paramString);
  
  @DISPID(3)
  @VTID(10)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject nodeById(int paramInt);
  
  @DISPID(4)
  @VTID(11)
  public abstract IList rootList(@Optional @DefaultValue("0") short paramShort);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITreeManager
 * JD-Core Version:    0.7.0.1
 */