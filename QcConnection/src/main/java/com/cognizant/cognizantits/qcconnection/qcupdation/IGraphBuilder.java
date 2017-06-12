package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{8F96D0C2-FFFE-4C6F-984E-CE022A50EA0E}")
public abstract interface IGraphBuilder
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject createGraphDefinition(int paramInt1, int paramInt2);
  
  @DISPID(2)
  @VTID(8)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildGraph(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(3)
  @VTID(9)
  public abstract IList buildMultipleGraphs(@MarshalAs(NativeType.VARIANT) Object paramObject);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IGraphBuilder
 * JD-Core Version:    0.7.0.1
 */