package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{8E64DE7A-F1C5-4EBF-925F-99441FE856FB}")
public abstract interface ICustomizationRBT2
  extends ICustomizationRBT
{
  @DISPID(60)
  @VTID(33)
  public abstract IList fcQuestions();
  
  @VTID(33)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object fcQuestions(int paramInt);
  
  @DISPID(61)
  @VTID(34)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject fcQuestionByID(int paramInt);
  
  @DISPID(62)
  @VTID(35)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addFCQuestion();
  
  @DISPID(63)
  @VTID(36)
  public abstract void deleteFCQuestion(int paramInt);
  
  @DISPID(64)
  @VTID(37)
  public abstract int fcLevelRiskLowerThreshold(int paramInt);
  
  @DISPID(64)
  @VTID(38)
  public abstract void fcLevelRiskLowerThreshold(int paramInt1, int paramInt2);
  
  @DISPID(65)
  @VTID(39)
  public abstract String translateFCLevel(int paramInt);
  
  @DISPID(66)
  @VTID(40)
  public abstract int calcFCLevelByAnswersWeight(int paramInt);
  
  @DISPID(67)
  @VTID(41)
  public abstract int riskCalculationMatrix(int paramInt1, int paramInt2);
  
  @DISPID(67)
  @VTID(42)
  public abstract void riskCalculationMatrix(int paramInt1, int paramInt2, int paramInt3);
  
  @DISPID(68)
  @VTID(43)
  public abstract int translateFPLevelDBNameToEnum(String paramString);
  
  @DISPID(69)
  @VTID(44)
  public abstract int translateBILevelDBNameToEnum(String paramString);
  
  @DISPID(70)
  @VTID(45)
  public abstract int testingEffortForFCLevel(int paramInt);
  
  @DISPID(70)
  @VTID(46)
  public abstract void testingEffortForFCLevel(int paramInt1, int paramInt2);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationRBT2
 * JD-Core Version:    0.7.0.1
 */