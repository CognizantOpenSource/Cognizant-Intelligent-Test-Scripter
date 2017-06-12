package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.Holder;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{590E515E-D527-4436-B04C-40942DBFFB5F}")
public abstract interface IBusinessProcess
  extends ITest
{
  @DISPID(100)
  @VTID(48)
  public abstract void load();
  
  @DISPID(101)
  @VTID(49)
  public abstract void save();
  
  @DISPID(102)
  @VTID(50)
  public abstract IList rtParameters();
  
  @VTID(50)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object rtParameters(int paramInt);
  
  @DISPID(103)
  @VTID(51)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addRTParam();
  
  @DISPID(104)
  @VTID(52)
  public abstract void deleteRTParam(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(105)
  @VTID(53)
  public abstract IList bpComponents();
  
  @VTID(53)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object bpComponents(int paramInt);
  
  @DISPID(106)
  @VTID(54)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addBPComponent(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(107)
  @VTID(55)
  public abstract void deleteBPComponent(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(108)
  @VTID(56)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addGroup();
  
  @DISPID(109)
  @VTID(57)
  public abstract void deleteGroup(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(110)
  @VTID(58)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject groupByID(int paramInt);
  
  @DISPID(111)
  @VTID(59)
  public abstract void downloadPictures();
  
  @DISPID(112)
  @VTID(60)
  public abstract void downloadPicturesProgress(Holder<Integer> paramHolder1, Holder<Integer> paramHolder2);
  
  @DISPID(113)
  @VTID(61)
  public abstract void cancelDownloadPictures();
  
  @DISPID(114)
  @VTID(62)
  public abstract String htmlScript();
  
  @DISPID(115)
  @VTID(63)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject bptHistory();
  
  @DISPID(116)
  @VTID(64)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject bpComponentByID(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBusinessProcess
 * JD-Core Version:    0.7.0.1
 */