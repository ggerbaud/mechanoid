/**
 */
package com.robotoworks.mechanoid.sqlite.sqliteModel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.robotoworks.mechanoid.sqlite.sqliteModel.ActionStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.AlterTableAddColumnStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.AlterTableRenameStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.Case;
import com.robotoworks.mechanoid.sqlite.sqliteModel.CaseExpression;
import com.robotoworks.mechanoid.sqlite.sqliteModel.CastExpression;
import com.robotoworks.mechanoid.sqlite.sqliteModel.CheckTableConstraint;
import com.robotoworks.mechanoid.sqlite.sqliteModel.ColumnConstraint;
import com.robotoworks.mechanoid.sqlite.sqliteModel.ColumnDef;
import com.robotoworks.mechanoid.sqlite.sqliteModel.ColumnSource;
import com.robotoworks.mechanoid.sqlite.sqliteModel.ColumnSourceRef;
import com.robotoworks.mechanoid.sqlite.sqliteModel.ConfigBlock;
import com.robotoworks.mechanoid.sqlite.sqliteModel.ConfigurationStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.ConflictClause;
import com.robotoworks.mechanoid.sqlite.sqliteModel.CreateTableStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.CreateTriggerStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.CreateViewStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.CurrentDateLiteral;
import com.robotoworks.mechanoid.sqlite.sqliteModel.CurrentTimeLiteral;
import com.robotoworks.mechanoid.sqlite.sqliteModel.CurrentTimeStampLiteral;
import com.robotoworks.mechanoid.sqlite.sqliteModel.DDLStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.DMLStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.DatabaseBlock;
import com.robotoworks.mechanoid.sqlite.sqliteModel.DefaultConstraint;
import com.robotoworks.mechanoid.sqlite.sqliteModel.DefaultValue;
import com.robotoworks.mechanoid.sqlite.sqliteModel.DeleteStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.DropTableStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.DropTriggerStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.DropViewStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.ExprAdd;
import com.robotoworks.mechanoid.sqlite.sqliteModel.ExprAnd;
import com.robotoworks.mechanoid.sqlite.sqliteModel.ExprBit;
import com.robotoworks.mechanoid.sqlite.sqliteModel.ExprConcat;
import com.robotoworks.mechanoid.sqlite.sqliteModel.ExprEqual;
import com.robotoworks.mechanoid.sqlite.sqliteModel.ExprMult;
import com.robotoworks.mechanoid.sqlite.sqliteModel.ExprOr;
import com.robotoworks.mechanoid.sqlite.sqliteModel.ExprRelate;
import com.robotoworks.mechanoid.sqlite.sqliteModel.Expression;
import com.robotoworks.mechanoid.sqlite.sqliteModel.ExpressionDefaultValue;
import com.robotoworks.mechanoid.sqlite.sqliteModel.Function;
import com.robotoworks.mechanoid.sqlite.sqliteModel.GroupByExpressions;
import com.robotoworks.mechanoid.sqlite.sqliteModel.HavingExpressions;
import com.robotoworks.mechanoid.sqlite.sqliteModel.IndexedColumn;
import com.robotoworks.mechanoid.sqlite.sqliteModel.InsertStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.IsNull;
import com.robotoworks.mechanoid.sqlite.sqliteModel.JoinSource;
import com.robotoworks.mechanoid.sqlite.sqliteModel.JoinStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.Literal;
import com.robotoworks.mechanoid.sqlite.sqliteModel.LiteralDefaultValue;
import com.robotoworks.mechanoid.sqlite.sqliteModel.LiteralValue;
import com.robotoworks.mechanoid.sqlite.sqliteModel.MigrationBlock;
import com.robotoworks.mechanoid.sqlite.sqliteModel.Model;
import com.robotoworks.mechanoid.sqlite.sqliteModel.NestedExpression;
import com.robotoworks.mechanoid.sqlite.sqliteModel.NewColumn;
import com.robotoworks.mechanoid.sqlite.sqliteModel.NotNull;
import com.robotoworks.mechanoid.sqlite.sqliteModel.NotNullConstraint;
import com.robotoworks.mechanoid.sqlite.sqliteModel.NullCheckExpression;
import com.robotoworks.mechanoid.sqlite.sqliteModel.NullLiteral;
import com.robotoworks.mechanoid.sqlite.sqliteModel.NumericLiteral;
import com.robotoworks.mechanoid.sqlite.sqliteModel.OldColumn;
import com.robotoworks.mechanoid.sqlite.sqliteModel.OrderingTerm;
import com.robotoworks.mechanoid.sqlite.sqliteModel.OrderingTermList;
import com.robotoworks.mechanoid.sqlite.sqliteModel.PrimaryConstraint;
import com.robotoworks.mechanoid.sqlite.sqliteModel.PrimaryKeyColumnConstraint;
import com.robotoworks.mechanoid.sqlite.sqliteModel.ResultColumn;
import com.robotoworks.mechanoid.sqlite.sqliteModel.SelectCore;
import com.robotoworks.mechanoid.sqlite.sqliteModel.SelectCoreExpression;
import com.robotoworks.mechanoid.sqlite.sqliteModel.SelectExpression;
import com.robotoworks.mechanoid.sqlite.sqliteModel.SelectList;
import com.robotoworks.mechanoid.sqlite.sqliteModel.SelectSource;
import com.robotoworks.mechanoid.sqlite.sqliteModel.SelectStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.SelectStatementExpression;
import com.robotoworks.mechanoid.sqlite.sqliteModel.SingleSource;
import com.robotoworks.mechanoid.sqlite.sqliteModel.SingleSourceJoin;
import com.robotoworks.mechanoid.sqlite.sqliteModel.SingleSourceSelectStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.SingleSourceTable;
import com.robotoworks.mechanoid.sqlite.sqliteModel.SqliteModelPackage;
import com.robotoworks.mechanoid.sqlite.sqliteModel.StringLiteral;
import com.robotoworks.mechanoid.sqlite.sqliteModel.TableConstraint;
import com.robotoworks.mechanoid.sqlite.sqliteModel.TableDefinition;
import com.robotoworks.mechanoid.sqlite.sqliteModel.UniqueTableConstraint;
import com.robotoworks.mechanoid.sqlite.sqliteModel.UpdateColumnExpression;
import com.robotoworks.mechanoid.sqlite.sqliteModel.UpdateStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.WhereExpressions;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.robotoworks.mechanoid.sqlite.sqliteModel.SqliteModelPackage
 * @generated
 */
public class SqliteModelAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static SqliteModelPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SqliteModelAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = SqliteModelPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SqliteModelSwitch<Adapter> modelSwitch =
    new SqliteModelSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseDatabaseBlock(DatabaseBlock object)
      {
        return createDatabaseBlockAdapter();
      }
      @Override
      public Adapter caseConfigBlock(ConfigBlock object)
      {
        return createConfigBlockAdapter();
      }
      @Override
      public Adapter caseConfigurationStatement(ConfigurationStatement object)
      {
        return createConfigurationStatementAdapter();
      }
      @Override
      public Adapter caseMigrationBlock(MigrationBlock object)
      {
        return createMigrationBlockAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseCase(Case object)
      {
        return createCaseAdapter();
      }
      @Override
      public Adapter caseSelectStatement(SelectStatement object)
      {
        return createSelectStatementAdapter();
      }
      @Override
      public Adapter caseOrderingTermList(OrderingTermList object)
      {
        return createOrderingTermListAdapter();
      }
      @Override
      public Adapter caseSelectCoreExpression(SelectCoreExpression object)
      {
        return createSelectCoreExpressionAdapter();
      }
      @Override
      public Adapter caseSelectList(SelectList object)
      {
        return createSelectListAdapter();
      }
      @Override
      public Adapter caseWhereExpressions(WhereExpressions object)
      {
        return createWhereExpressionsAdapter();
      }
      @Override
      public Adapter caseGroupByExpressions(GroupByExpressions object)
      {
        return createGroupByExpressionsAdapter();
      }
      @Override
      public Adapter caseHavingExpressions(HavingExpressions object)
      {
        return createHavingExpressionsAdapter();
      }
      @Override
      public Adapter caseOrderingTerm(OrderingTerm object)
      {
        return createOrderingTermAdapter();
      }
      @Override
      public Adapter caseJoinSource(JoinSource object)
      {
        return createJoinSourceAdapter();
      }
      @Override
      public Adapter caseSingleSource(SingleSource object)
      {
        return createSingleSourceAdapter();
      }
      @Override
      public Adapter caseSelectSource(SelectSource object)
      {
        return createSelectSourceAdapter();
      }
      @Override
      public Adapter caseSingleSourceJoin(SingleSourceJoin object)
      {
        return createSingleSourceJoinAdapter();
      }
      @Override
      public Adapter caseJoinStatement(JoinStatement object)
      {
        return createJoinStatementAdapter();
      }
      @Override
      public Adapter caseColumnSource(ColumnSource object)
      {
        return createColumnSourceAdapter();
      }
      @Override
      public Adapter caseLiteralValue(LiteralValue object)
      {
        return createLiteralValueAdapter();
      }
      @Override
      public Adapter caseDDLStatement(DDLStatement object)
      {
        return createDDLStatementAdapter();
      }
      @Override
      public Adapter caseTableDefinition(TableDefinition object)
      {
        return createTableDefinitionAdapter();
      }
      @Override
      public Adapter caseCreateViewStatement(CreateViewStatement object)
      {
        return createCreateViewStatementAdapter();
      }
      @Override
      public Adapter caseCreateTriggerStatement(CreateTriggerStatement object)
      {
        return createCreateTriggerStatementAdapter();
      }
      @Override
      public Adapter caseAlterTableAddColumnStatement(AlterTableAddColumnStatement object)
      {
        return createAlterTableAddColumnStatementAdapter();
      }
      @Override
      public Adapter caseDropTableStatement(DropTableStatement object)
      {
        return createDropTableStatementAdapter();
      }
      @Override
      public Adapter caseDropTriggerStatement(DropTriggerStatement object)
      {
        return createDropTriggerStatementAdapter();
      }
      @Override
      public Adapter caseDropViewStatement(DropViewStatement object)
      {
        return createDropViewStatementAdapter();
      }
      @Override
      public Adapter caseColumnConstraint(ColumnConstraint object)
      {
        return createColumnConstraintAdapter();
      }
      @Override
      public Adapter caseTableConstraint(TableConstraint object)
      {
        return createTableConstraintAdapter();
      }
      @Override
      public Adapter caseUniqueTableConstraint(UniqueTableConstraint object)
      {
        return createUniqueTableConstraintAdapter();
      }
      @Override
      public Adapter casePrimaryConstraint(PrimaryConstraint object)
      {
        return createPrimaryConstraintAdapter();
      }
      @Override
      public Adapter caseCheckTableConstraint(CheckTableConstraint object)
      {
        return createCheckTableConstraintAdapter();
      }
      @Override
      public Adapter caseIndexedColumn(IndexedColumn object)
      {
        return createIndexedColumnAdapter();
      }
      @Override
      public Adapter caseDefaultValue(DefaultValue object)
      {
        return createDefaultValueAdapter();
      }
      @Override
      public Adapter caseConflictClause(ConflictClause object)
      {
        return createConflictClauseAdapter();
      }
      @Override
      public Adapter caseDMLStatement(DMLStatement object)
      {
        return createDMLStatementAdapter();
      }
      @Override
      public Adapter caseDeleteStatement(DeleteStatement object)
      {
        return createDeleteStatementAdapter();
      }
      @Override
      public Adapter caseInsertStatement(InsertStatement object)
      {
        return createInsertStatementAdapter();
      }
      @Override
      public Adapter caseUpdateStatement(UpdateStatement object)
      {
        return createUpdateStatementAdapter();
      }
      @Override
      public Adapter caseUpdateColumnExpression(UpdateColumnExpression object)
      {
        return createUpdateColumnExpressionAdapter();
      }
      @Override
      public Adapter caseActionStatement(ActionStatement object)
      {
        return createActionStatementAdapter();
      }
      @Override
      public Adapter caseExprConcat(ExprConcat object)
      {
        return createExprConcatAdapter();
      }
      @Override
      public Adapter caseExprMult(ExprMult object)
      {
        return createExprMultAdapter();
      }
      @Override
      public Adapter caseExprAdd(ExprAdd object)
      {
        return createExprAddAdapter();
      }
      @Override
      public Adapter caseExprBit(ExprBit object)
      {
        return createExprBitAdapter();
      }
      @Override
      public Adapter caseExprRelate(ExprRelate object)
      {
        return createExprRelateAdapter();
      }
      @Override
      public Adapter caseExprEqual(ExprEqual object)
      {
        return createExprEqualAdapter();
      }
      @Override
      public Adapter caseExprAnd(ExprAnd object)
      {
        return createExprAndAdapter();
      }
      @Override
      public Adapter caseExprOr(ExprOr object)
      {
        return createExprOrAdapter();
      }
      @Override
      public Adapter caseNullCheckExpression(NullCheckExpression object)
      {
        return createNullCheckExpressionAdapter();
      }
      @Override
      public Adapter caseIsNull(IsNull object)
      {
        return createIsNullAdapter();
      }
      @Override
      public Adapter caseNotNull(NotNull object)
      {
        return createNotNullAdapter();
      }
      @Override
      public Adapter caseNewColumn(NewColumn object)
      {
        return createNewColumnAdapter();
      }
      @Override
      public Adapter caseOldColumn(OldColumn object)
      {
        return createOldColumnAdapter();
      }
      @Override
      public Adapter caseColumnSourceRef(ColumnSourceRef object)
      {
        return createColumnSourceRefAdapter();
      }
      @Override
      public Adapter caseLiteral(Literal object)
      {
        return createLiteralAdapter();
      }
      @Override
      public Adapter caseNestedExpression(NestedExpression object)
      {
        return createNestedExpressionAdapter();
      }
      @Override
      public Adapter caseSelectStatementExpression(SelectStatementExpression object)
      {
        return createSelectStatementExpressionAdapter();
      }
      @Override
      public Adapter caseCaseExpression(CaseExpression object)
      {
        return createCaseExpressionAdapter();
      }
      @Override
      public Adapter caseFunction(Function object)
      {
        return createFunctionAdapter();
      }
      @Override
      public Adapter caseCastExpression(CastExpression object)
      {
        return createCastExpressionAdapter();
      }
      @Override
      public Adapter caseSelectCore(SelectCore object)
      {
        return createSelectCoreAdapter();
      }
      @Override
      public Adapter caseSelectExpression(SelectExpression object)
      {
        return createSelectExpressionAdapter();
      }
      @Override
      public Adapter caseSingleSourceTable(SingleSourceTable object)
      {
        return createSingleSourceTableAdapter();
      }
      @Override
      public Adapter caseSingleSourceSelectStatement(SingleSourceSelectStatement object)
      {
        return createSingleSourceSelectStatementAdapter();
      }
      @Override
      public Adapter caseResultColumn(ResultColumn object)
      {
        return createResultColumnAdapter();
      }
      @Override
      public Adapter caseNumericLiteral(NumericLiteral object)
      {
        return createNumericLiteralAdapter();
      }
      @Override
      public Adapter caseStringLiteral(StringLiteral object)
      {
        return createStringLiteralAdapter();
      }
      @Override
      public Adapter caseNullLiteral(NullLiteral object)
      {
        return createNullLiteralAdapter();
      }
      @Override
      public Adapter caseCurrentTimeLiteral(CurrentTimeLiteral object)
      {
        return createCurrentTimeLiteralAdapter();
      }
      @Override
      public Adapter caseCurrentDateLiteral(CurrentDateLiteral object)
      {
        return createCurrentDateLiteralAdapter();
      }
      @Override
      public Adapter caseCurrentTimeStampLiteral(CurrentTimeStampLiteral object)
      {
        return createCurrentTimeStampLiteralAdapter();
      }
      @Override
      public Adapter caseCreateTableStatement(CreateTableStatement object)
      {
        return createCreateTableStatementAdapter();
      }
      @Override
      public Adapter caseAlterTableRenameStatement(AlterTableRenameStatement object)
      {
        return createAlterTableRenameStatementAdapter();
      }
      @Override
      public Adapter caseColumnDef(ColumnDef object)
      {
        return createColumnDefAdapter();
      }
      @Override
      public Adapter casePrimaryKeyColumnConstraint(PrimaryKeyColumnConstraint object)
      {
        return createPrimaryKeyColumnConstraintAdapter();
      }
      @Override
      public Adapter caseNotNullConstraint(NotNullConstraint object)
      {
        return createNotNullConstraintAdapter();
      }
      @Override
      public Adapter caseDefaultConstraint(DefaultConstraint object)
      {
        return createDefaultConstraintAdapter();
      }
      @Override
      public Adapter caseLiteralDefaultValue(LiteralDefaultValue object)
      {
        return createLiteralDefaultValueAdapter();
      }
      @Override
      public Adapter caseExpressionDefaultValue(ExpressionDefaultValue object)
      {
        return createExpressionDefaultValueAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.DatabaseBlock <em>Database Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.DatabaseBlock
   * @generated
   */
  public Adapter createDatabaseBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.ConfigBlock <em>Config Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.ConfigBlock
   * @generated
   */
  public Adapter createConfigBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.ConfigurationStatement <em>Configuration Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.ConfigurationStatement
   * @generated
   */
  public Adapter createConfigurationStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.MigrationBlock <em>Migration Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.MigrationBlock
   * @generated
   */
  public Adapter createMigrationBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.Case <em>Case</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.Case
   * @generated
   */
  public Adapter createCaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.SelectStatement <em>Select Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.SelectStatement
   * @generated
   */
  public Adapter createSelectStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.OrderingTermList <em>Ordering Term List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.OrderingTermList
   * @generated
   */
  public Adapter createOrderingTermListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.SelectCoreExpression <em>Select Core Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.SelectCoreExpression
   * @generated
   */
  public Adapter createSelectCoreExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.SelectList <em>Select List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.SelectList
   * @generated
   */
  public Adapter createSelectListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.WhereExpressions <em>Where Expressions</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.WhereExpressions
   * @generated
   */
  public Adapter createWhereExpressionsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.GroupByExpressions <em>Group By Expressions</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.GroupByExpressions
   * @generated
   */
  public Adapter createGroupByExpressionsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.HavingExpressions <em>Having Expressions</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.HavingExpressions
   * @generated
   */
  public Adapter createHavingExpressionsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.OrderingTerm <em>Ordering Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.OrderingTerm
   * @generated
   */
  public Adapter createOrderingTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.JoinSource <em>Join Source</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.JoinSource
   * @generated
   */
  public Adapter createJoinSourceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.SingleSource <em>Single Source</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.SingleSource
   * @generated
   */
  public Adapter createSingleSourceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.SelectSource <em>Select Source</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.SelectSource
   * @generated
   */
  public Adapter createSelectSourceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.SingleSourceJoin <em>Single Source Join</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.SingleSourceJoin
   * @generated
   */
  public Adapter createSingleSourceJoinAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.JoinStatement <em>Join Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.JoinStatement
   * @generated
   */
  public Adapter createJoinStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.ColumnSource <em>Column Source</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.ColumnSource
   * @generated
   */
  public Adapter createColumnSourceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.LiteralValue <em>Literal Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.LiteralValue
   * @generated
   */
  public Adapter createLiteralValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.DDLStatement <em>DDL Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.DDLStatement
   * @generated
   */
  public Adapter createDDLStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.TableDefinition <em>Table Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.TableDefinition
   * @generated
   */
  public Adapter createTableDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.CreateViewStatement <em>Create View Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.CreateViewStatement
   * @generated
   */
  public Adapter createCreateViewStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.CreateTriggerStatement <em>Create Trigger Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.CreateTriggerStatement
   * @generated
   */
  public Adapter createCreateTriggerStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.AlterTableAddColumnStatement <em>Alter Table Add Column Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.AlterTableAddColumnStatement
   * @generated
   */
  public Adapter createAlterTableAddColumnStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.DropTableStatement <em>Drop Table Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.DropTableStatement
   * @generated
   */
  public Adapter createDropTableStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.DropTriggerStatement <em>Drop Trigger Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.DropTriggerStatement
   * @generated
   */
  public Adapter createDropTriggerStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.DropViewStatement <em>Drop View Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.DropViewStatement
   * @generated
   */
  public Adapter createDropViewStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.ColumnConstraint <em>Column Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.ColumnConstraint
   * @generated
   */
  public Adapter createColumnConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.TableConstraint <em>Table Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.TableConstraint
   * @generated
   */
  public Adapter createTableConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.UniqueTableConstraint <em>Unique Table Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.UniqueTableConstraint
   * @generated
   */
  public Adapter createUniqueTableConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.PrimaryConstraint <em>Primary Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.PrimaryConstraint
   * @generated
   */
  public Adapter createPrimaryConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.CheckTableConstraint <em>Check Table Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.CheckTableConstraint
   * @generated
   */
  public Adapter createCheckTableConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.IndexedColumn <em>Indexed Column</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.IndexedColumn
   * @generated
   */
  public Adapter createIndexedColumnAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.DefaultValue <em>Default Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.DefaultValue
   * @generated
   */
  public Adapter createDefaultValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.ConflictClause <em>Conflict Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.ConflictClause
   * @generated
   */
  public Adapter createConflictClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.DMLStatement <em>DML Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.DMLStatement
   * @generated
   */
  public Adapter createDMLStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.DeleteStatement <em>Delete Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.DeleteStatement
   * @generated
   */
  public Adapter createDeleteStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.InsertStatement <em>Insert Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.InsertStatement
   * @generated
   */
  public Adapter createInsertStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.UpdateStatement <em>Update Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.UpdateStatement
   * @generated
   */
  public Adapter createUpdateStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.UpdateColumnExpression <em>Update Column Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.UpdateColumnExpression
   * @generated
   */
  public Adapter createUpdateColumnExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.ActionStatement <em>Action Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.ActionStatement
   * @generated
   */
  public Adapter createActionStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.ExprConcat <em>Expr Concat</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.ExprConcat
   * @generated
   */
  public Adapter createExprConcatAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.ExprMult <em>Expr Mult</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.ExprMult
   * @generated
   */
  public Adapter createExprMultAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.ExprAdd <em>Expr Add</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.ExprAdd
   * @generated
   */
  public Adapter createExprAddAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.ExprBit <em>Expr Bit</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.ExprBit
   * @generated
   */
  public Adapter createExprBitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.ExprRelate <em>Expr Relate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.ExprRelate
   * @generated
   */
  public Adapter createExprRelateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.ExprEqual <em>Expr Equal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.ExprEqual
   * @generated
   */
  public Adapter createExprEqualAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.ExprAnd <em>Expr And</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.ExprAnd
   * @generated
   */
  public Adapter createExprAndAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.ExprOr <em>Expr Or</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.ExprOr
   * @generated
   */
  public Adapter createExprOrAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.NullCheckExpression <em>Null Check Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.NullCheckExpression
   * @generated
   */
  public Adapter createNullCheckExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.IsNull <em>Is Null</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.IsNull
   * @generated
   */
  public Adapter createIsNullAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.NotNull <em>Not Null</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.NotNull
   * @generated
   */
  public Adapter createNotNullAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.NewColumn <em>New Column</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.NewColumn
   * @generated
   */
  public Adapter createNewColumnAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.OldColumn <em>Old Column</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.OldColumn
   * @generated
   */
  public Adapter createOldColumnAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.ColumnSourceRef <em>Column Source Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.ColumnSourceRef
   * @generated
   */
  public Adapter createColumnSourceRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.Literal
   * @generated
   */
  public Adapter createLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.NestedExpression <em>Nested Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.NestedExpression
   * @generated
   */
  public Adapter createNestedExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.SelectStatementExpression <em>Select Statement Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.SelectStatementExpression
   * @generated
   */
  public Adapter createSelectStatementExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.CaseExpression <em>Case Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.CaseExpression
   * @generated
   */
  public Adapter createCaseExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.Function
   * @generated
   */
  public Adapter createFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.CastExpression <em>Cast Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.CastExpression
   * @generated
   */
  public Adapter createCastExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.SelectCore <em>Select Core</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.SelectCore
   * @generated
   */
  public Adapter createSelectCoreAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.SelectExpression <em>Select Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.SelectExpression
   * @generated
   */
  public Adapter createSelectExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.SingleSourceTable <em>Single Source Table</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.SingleSourceTable
   * @generated
   */
  public Adapter createSingleSourceTableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.SingleSourceSelectStatement <em>Single Source Select Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.SingleSourceSelectStatement
   * @generated
   */
  public Adapter createSingleSourceSelectStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.ResultColumn <em>Result Column</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.ResultColumn
   * @generated
   */
  public Adapter createResultColumnAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.NumericLiteral <em>Numeric Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.NumericLiteral
   * @generated
   */
  public Adapter createNumericLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.StringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.StringLiteral
   * @generated
   */
  public Adapter createStringLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.NullLiteral <em>Null Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.NullLiteral
   * @generated
   */
  public Adapter createNullLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.CurrentTimeLiteral <em>Current Time Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.CurrentTimeLiteral
   * @generated
   */
  public Adapter createCurrentTimeLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.CurrentDateLiteral <em>Current Date Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.CurrentDateLiteral
   * @generated
   */
  public Adapter createCurrentDateLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.CurrentTimeStampLiteral <em>Current Time Stamp Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.CurrentTimeStampLiteral
   * @generated
   */
  public Adapter createCurrentTimeStampLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.CreateTableStatement <em>Create Table Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.CreateTableStatement
   * @generated
   */
  public Adapter createCreateTableStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.AlterTableRenameStatement <em>Alter Table Rename Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.AlterTableRenameStatement
   * @generated
   */
  public Adapter createAlterTableRenameStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.ColumnDef <em>Column Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.ColumnDef
   * @generated
   */
  public Adapter createColumnDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.PrimaryKeyColumnConstraint <em>Primary Key Column Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.PrimaryKeyColumnConstraint
   * @generated
   */
  public Adapter createPrimaryKeyColumnConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.NotNullConstraint <em>Not Null Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.NotNullConstraint
   * @generated
   */
  public Adapter createNotNullConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.DefaultConstraint <em>Default Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.DefaultConstraint
   * @generated
   */
  public Adapter createDefaultConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.LiteralDefaultValue <em>Literal Default Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.LiteralDefaultValue
   * @generated
   */
  public Adapter createLiteralDefaultValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.robotoworks.mechanoid.sqlite.sqliteModel.ExpressionDefaultValue <em>Expression Default Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.robotoworks.mechanoid.sqlite.sqliteModel.ExpressionDefaultValue
   * @generated
   */
  public Adapter createExpressionDefaultValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //SqliteModelAdapterFactory
