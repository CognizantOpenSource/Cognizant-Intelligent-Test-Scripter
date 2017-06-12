package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultMethod;
import com4j.DefaultValue;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{8538CCBA-0B3E-481F-BB2B-14F0553CA146}")
public abstract interface ISysTreeNode
  extends Com4jObject
{
  @DISPID(0)
  @VTID(7)
  @DefaultMethod
  public abstract String name();
  
  @DISPID(0)
  @VTID(8)
  @DefaultMethod
  public abstract void name(String paramString);
  
  @DISPID(1)
  @VTID(9)
  public abstract ISysTreeNode addNode(String paramString);
  
  @DISPID(2)
  @VTID(10)
  public abstract IList newList();
  
  @VTID(10)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object newList(int paramInt);
  
  @DISPID(3)
  @VTID(11)
  public abstract int nodeID();
  
  @DISPID(4)
  @VTID(12)
  public abstract int attribute();
  
  @DISPID(5)
  @VTID(13)
  public abstract ISysTreeNode findChildNode(String paramString);
  
  @DISPID(6)
  @VTID(14)
  public abstract void removeNode(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(7)
  @VTID(15)
  public abstract ISysTreeNode father();
  
  @DISPID(8)
  @VTID(16)
  public abstract ISysTreeNode child(int paramInt);
  
  @DISPID(9)
  @VTID(17)
  public abstract int count();
  
  @DISPID(10)
  @VTID(18)
  public abstract short depthType();
  
  @DISPID(11)
  @VTID(19)
  public abstract IList findChildren(String paramString1, @Optional @DefaultValue("0") boolean paramBoolean, @Optional @DefaultValue("") String paramString2);
  
  @DISPID(12)
  @VTID(20)
  public abstract String path();
  
  @DISPID(13)
  @VTID(21)
  public abstract void post();
  
  @DISPID(14)
  @VTID(22)
  public abstract void refresh();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ISysTreeNode
 * JD-Core Version:    0.7.0.1
 */