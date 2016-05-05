package data;

import java.util.HashMap;
import java.util.Map;

public class ARConstants {
	/**
	 * Private constructor.
	 */
	private ARConstants() {
		// Don't allow instantiation of this class, no need.
	}
	
	public static final double ONE_MINUTE = 0.00002;
	public static final double LAST_DAY_OF_MONTH_OFFSET = 1.0 - ONE_MINUTE;
	public static final double WHOLE_MONTH_OFFSET = 1.0 - ONE_MINUTE / 2.0;
	
	// TODO: Do these belong in an enum?
	public static final String REASON_BLOCK_OUTAGE = "BLOCK_DRIVEN_OUTAGE";
	public static final String REASON_SCRAP_BY_RECONFIG = "SCRAP_DUE_TO_RECONFIG";
	public static final String REASON_RECONFIG = "RECONFIGURATION";
	public static final String REASON_MANUAL_EVENT = "MANUAL_EVENT";
	public static final String REASON_EARLY_MOB = "EARLY_MOB";
	public static final String REASON_SCRAP_BY_FALLOUT = "EARLY_SCRAP_VIA_FALLOUT";
	public static final String REASON_EARLY_OUTAGE_SAVE_PURCHASE = "PULL_EARLY_TO_MAKE_PART_AVAILABLE_FOR_NEXT_OUTAGE";
	public static final String REASON_LATE_OUTAGE_SAVE_PURCHASE_NEXT = "PUSH_NEXT_EVENT_OUT_TO_AVOID_PURCHASE";
	public static final String REASON_LATE_OUTAGE_SAVE_PURCHASE = "PUSH_EVENT_OUT_TO_AVOID_PURCHASE";
	public static final String REASON_EARLY_OUTAGE_STAGGER_OUTAGE = "PULL_EARLY_FOR_STAGGER_WINDOW";
	public static final String REASON_LATE_OUTAGE_STAGGER_OUTAGE_NEXT = "PUSH_NEXT_EVENT_OUT_FOR_STAGGER_WINDOW";
	public static final String REASON_LATE_OUTAGE_STAGGER_OUTAGE = "PUSH_EVENT_OUT_FOR_STAGGER_WINDOW";
	public static final String REASON_PART_IN_SHOP = "INVENTORY_IN_SHOP";
	public static final String MDL_MONITOR = "MDL_MONITOR";
	public static final String MDL_STATUS_COMPLETE = "COMPLETE";
	public static final String MDL_STATUS_TIMEOUT = "TIMEOUT";
	public static final String MDL_STATUS_INPROG = "IN_PROGRESS";
	public static final String MDL_STATUS_FAIL = "FAILURE";
	public final static double DOUBLE_EPSILON = 0.00000001d;
	public final static double NUMERIC_TWO = 2;
	public final static double LOOPCOUNTER = 100;
	public final static String RUNTYPEMDL = "CSAMDL";
	public final static String RUNTYPEFLEET = "CSAFLEET";
	public final static int MAXLOCKTIME = 60;
	public final static int MILLISECONDS = 1000; 
	public static final int CENTRAL_WAREHOUSE_INDEX = 0;
	
	// Search related constants
	public static final int MAX_POOL_SIZE = 100; // Max # active nodes
	public static final String SERIALIZATION_DIR = "C:/test/";
	public static final String ROOT_NODE_ID = "R";
	public static final String PWF_QUEUE ="pwfQueue";

	
	/***************** Defining Dao constants ************************/
	public static final String DAO_ACTUALSDATADAO = "actualsDataDAO";
	public static final String DAO_INSPECTDATADAO = "inspectDataDAO";
	public static final String DAO_MODELDATADAO = "modelDataDAO";
	public static final String DAO_CUSTOMDATADAO = "customDataDAO";
	public static final String DAO_INVSHAREDATADAO = "invShareDataDAO";
	public static final String DAO_EOTDATADAO = "eotDataDAO";
	public static final String DAO_CATALOGDATADAO = "catalogDataDAO";
	public static final String DAO_EQUIPCONFIGDATADAO = "equipConfigDataDAO";
	public static final String DAO_EQUIPDATADAO = "equipDataDAO";
	public static final String DAO_FALLOUTDATADAO = "falloutDataDAO";
	public static final String DAO_FALLOUTDATSCHREPAIRPARTDAO = "falloutSchRepairPartsDataDAO";
	public static final String DAO_FALLOUTCATALOGDAO = "falloutCatalogDAO";
	public static final String DAO_FALLOUTEQUIPINDDAO = "falloutEquipIndDataDAO";
	public static final String DAO_FALLOUTZTABLEDAO = "falloutZTableDataDAO";
	public static final String DAO_FALLOUTSTEPPARTKITDAO = "falloutStepDataDAO";
	public static final String DAO_FLEETCONFIGDATADAO = "fleetConfigDataDAO";
	public static final String DAO_FLEETDONOTSHAREWITHDAO = "fleetDoNotShareWithDAO";
	public static final String DAO_FLEETMODELDATADAO = "fleetModelDataDAO";
	public static final String DAO_FLEETLINKEDWAREHOUSESDAO = "fleetLinkedWarehousesDAO";
	public static final String DAO_TECHSHAREDATADAO = "techShareDataDAO";
	public static final String DAO_INVLINKDATADAO = "invLinkDataDAO";
	public static final String DAO_MANUALEVENTDATADAO = "manualEventDataDAO";
	public static final String DAO_OPPROFILEDATADAO = "opprofileDataDAO";
	public static final String DAO_OUTAGEDATADAO = "outageDataDAO";
	public static final String DAO_REPAIRDATADAO = "repairDataDAO";
	public static final String DAO_RECONFDATADAO = "reconfDataDAO";
	public static final String DAO_SERVICECOSTDATADAO = "serviceCostDataDAO";
	public static final String DAO_STAGGERDATADAO = "staggerDataDAO";
	public static final String DAO_SUPERSEDUREDATADAO = "supersedureDataDAO";
	public static final String DAO_INVENCONFIGDATADAO = "invenConfigDataDAO";
	public static final String DAO_INVENSHELFDATADAO = "invenShelfDataDAO";
	public static final String DAO_PARTSHELFDATADAO = "partShelfDataDAO";
	public static final String DAO_INVENLINKDATADAO = "invenLinkDataDAO";
	public static final String DAO_EALRYMOBDATADAO = "ealryMobDataDAO";
	public static final String DAO_PARTPURCHASEDATADAO = "partPurchaseDataDAO";
	public static final String INPUT_PROCESS_ROUTER = "inputProcessRouter";
	
	public static final String DAO_PARTIDCONFIGDATADAO = "partIdConfigDataDAO";
	public static final String DAO_ARTEMPDATALOADDAO = "arTempDataLoadDAO";
	public static final String DAO_SITEEQUIPCONFIGLOADDAO = "siteEquipConfigLoadDAO";
	public static final String DAO_CATPARTCONFIGLOADDAO = "catPartConfigLoadDAO";
	public static final String DAO_MODELCONFIGLOADDAO = "modelConfigLoadDAO";
	public static final String DAO_ACTUALCONFIGLOADDAO = "actualConfigLoadDAO";
	public static final String DAO_EQUIPCONFIGLOADDAO = "equipConfigLoadDAO";
	public static final String DAO_PARTCONFIGLOADDAO = "partConfigLoadDAO";
	public static final String DAO_INVENTORYCONFIGLOADDAO = "inventoryConfigLoadDAO";
	public static final String DAO_FLEETTEMPDATAENTRYDAO = "fleetTempDataEntryDAO";
	public static final String FLEETMODELDATARESULT = "fleetModelDataResult";
	public static final String FLEETDTLSRESULT = "fleetDtlsResult";
	public static final String FLEETLNKDINVRESULT = "fleetLnkdInvResult";
	public static final String FLEETDONOTSHRDATARESULT = "fleetDoNotShrDataResult";
	public static final String DAO_FLEETCONFIGLOADDAO = "fleetConfigLoadDao";

	
	/*********************** LOADER **********************/
	public static final String LOAD_MODELCONFIG = "modelConfigLoader";
	public static final String LOAD_EQUIPCONFIG = "equipConfig";
	public static final String LOAD_ACTUALCONFIG = "actualConfig";
	public static final String LOAD_INVENTORYCONFIG = "inventoryConfig";
	public static final String LOAD_PARTCONFIG = "partConfig";
	

	/********************** ICAM Constants ***************/
	public static final double PART_TOLERANCE_PERCENTAGE = 0.1;
	

	
	/*********************** DATA LOADER THREAD SEQUENCE **********************/
	public static final int MODELCONFIG = 1;
	public static final int ACTUALCONFIG = 2;
	public static final int EQUIPCONFIG = 3;
	public static final int PARTCONFIG = 4;
	public static final int INVENTORYCONFIG = 5;
	
	public static final String MODELCONFIG_THREAD = "loadModelConfig";
	public static final String EQUIPCONFIG_THREAD = "loadEquipConfig";
	public static final String ACTUALCONFIG_THREAD = "loadActualConfig";
	public static final String INVENTORYCONFIG_THREAD = "loadInventoryConfig";
	public static final String PARTCONFIG_THREAD = "loadPartConfig";
	
	public static final String ACTUALDATARESULT = "actEventResult";
	public static final String CBMDATARESULT = "cbmDataResult";
	public static final String CUSTOMLIMITRESULT = "customDataResult";
	public static final String PARTGROUPDATARESULT = "partGroupDataResult";
	public static final String CPLGROUPDATARESULT = "cplGroupDataResult";
	public static final String CSLGROUPDATARESULT = "cslGroupDataResult";
	public static final String CONTRACTDETAILS = "contractDetailsResult";
	public static final String MANUALEVENTSDETAILS = "manualEventsResult";
	public static final String MANUALEVENTSFORCEDDETAILS = "manualEventsForcedResult";
	public static final String EOTDATARESULT = "eotDataResult";
	public static final String LINKEDWAREHOUSERESULT = "linkedWareHouseResult";
	public static final String WAREHOUSEDATARESULT = "warehouseDataResult";
	public static final String SERVICECOSTDATARESULT = "serviceCostDataResult";
	public static final String EQUIPDATARESULT = "equipdataresult";
	public static final String CATALOGDATARESULT = "catalogDataResult";
	public static final String OPPROFILEDATARESULT = "opprofileDataResult";
	public static final String REPAIRDATARESULT = "repairDataResult";
	public static final String SUPERCEDUREDATARESULT = "supercedureDataResult";
	public static final String TECHSHAREDATARESULT = "techShareDataResult";
	public static final String EQUIPCONFIGDATARESULT = "equipConfigDataResult";
	public static final String RECONFIGDATARESULT = "reconfigDataResult";
	public static final String INVENSHELFDATARESULT = "invenShelfDataResult";
	public static final String INVSHAREDATARESULT = "invShareDataResult";
	public static final String INVENLINKDATARESULT = "invenLinkDataResult";
	public static final String PARTSHELFDATARESULT = "partShelfDataResult";
	public static final String MAXPARTIDRESULT = "maxPartIdResult";
	
	public static final String DEPARTURERESULT = "DepartureDataResult";
	// Below three constants added for - Event Hierarchy from DB
	public static final String EVENTHIERARCHYRESULT= "eventHierarchyResult"; 
	public static final String EVENTHIERARMASTERRESULT= "eventHierMasterResult"; 
	public static final String EVENTHIERARINSPECTMASTERRESULT= "eventHierInspectMasterResult";
	public static final String EVENTTYPIDANDNAMERESULT= "eventTypIdAndNameResult";
	
	/*********************** INPUT PROCESSOR RESPONSE **********************/
	public static final String SUCCESS = "success";
	public static final String FAILURE = "failure";
	public static final String INPROGRESS = "inprogress";
	
	public static final String APPLICATION_CONTEXT = "applicationContext_inputprocessor.xml";
	
	/*********************** BNB Execution Constants **********************/
	public static final String HAZELCAST_MAP = "autoRunData";
	public static final String HAZELCAST_MAP_KEY = "autoRunData_";
	public static final String HAZELCAST_INPUT_PROCESS_LOCK = "InputProcessor_Lock";
	public static final String AR_MASTER_EXECUTOR="masterexecutor";
	public static final String BNB_EXECUTOR="bnbexecutor";
	public static final String DETERMINE_PARTS_OPTIONS_EXECUTOR="DeterminePartOptions";
	public static final String INSTALL_PARTS_EXECUTOR="InstallParts";
	public static final String SOLUTION_VARIABLE = "solutions";
	
	public static final String EVENT_LIST_MAP="eventList";
	public static final String EVENT_LIST_MAP_KEY="EventList_";
	
	public static final boolean STORE_BRANCH_DATA = true;
	
	public static final boolean HC_DEBUG_SETUP = false;

	public static final boolean ERROR_STACK_ENABLE = true;
	
	public static final String ACTIVE_NODES_VARIABLE = "activeNodes";
	public static final String MAX_ACTIVE_NODE_COUNT_VARIABLE = "maxActiveNodes";
	public static final String TOTAL_NODE_COUNT_VARIABLE = "totalNodes";
	public static final String TOTAL_SOLUTIONS_VARIABLE = "totalSolutionsFound";
	public static final String TOTAL_ABORTED_VARIABLE = "totalAbortedBranches";
	public static final String TOTAL_PRUNED_VARIABLE = "totalPrunedBranches";	
	public static final String EXECUTION_COMPLETION = "executionCompletion";
	public static final String COMPLETE_STATUS="complete";
	
	public static final String BNB_CONFIG_PROPERTY_FILE="/bnbconfig.properties";
	public static final String BNB_SEARCH_LEVEL="bnb.search.level";
	public static final String BNB_STAGGERING_FLAG="bnb.staggering.enable";
	public static final String BNB_EMOB_FLAG="bnb.earlymob.enable";
	public static final String IS_TRUE="True";
	public static final String DAO_OUTAGESCHEDULE = "outageDataDAO";
	public static final String MDL_HARDCLOSE_MAP = "MDL_HARDCLOSE_MAP";

	/**
	 * Constant added to store Discarded solutions
	 */
	public static final String SOLUTION_QUEUE="solutionQueue";
	public static final String OPERATION_COMPLETE_MAP ="operationComplete";

	public static final String FLEET_FLAG="CSAFLEET";
	public static final String MODEL_FLAG="CSAMDL";
	public static final String BASELINE_DATA_OBJECT ="baselineDataObject";


	public static final int HUNDRED = 100;
	public static final int INITIAL_ARRAYLIST_SIZE = 1;
	public static final int ONE = 1;
	public static final int TWO = 2;
	public static final int ZERO = 0;
	public static final int NEG_ONE = -1;
	public static final String EX = "Ex";
	public static final String SQRTVARX = "SqrtVariance";
	public static final String DISTMODE_LOGNORMAL = "LOGNORMAL";
	public static final String FAILUREMODE_FFH = "FFH";
	public static final String FAILUREMODE_FFS = "FFS";
	public static final String FAILUREMODE_COMBINED = "COMBINED";
	public static final int CURSOR_FETCH_SIZE = 100;
	public static final String EXCEPTION_MAP = "Exception";
	public static final String LOCKED_FLEET_EVENT_LIST = "lockedFleetEventList";
	public static final String RUN_ID_FLEET_LIST = "runIDFleetList";
	public static final String EQP_CATALOG_MAP="equipCatalog";
	
	public static final String SEPERATOR="~";
	public static final int EOT_EVENT = 3;
	
	/**********************Hazalcast Run COnfiguration Parameters**************************************/
	public static final int EXECUTOR_POOL_SIZE = 40;
	public static final int EXECUTOR_POOL_CAPACITY = 1000;
	public static final String PWF_LOCK ="pwfLock";
	public static final String PWF_CONDITION ="pwfCondition";
	public static final String RUN_COUNTER ="runCounter";
	public static final String RUN_LOCK ="runlock";
	public static final String RUN_CONDITION ="runCondition";
	
	public static final String PRUNED_BRANCH_COUNT ="prunedCount";
	public static final String ABORT_BRANCH_COUNT = "abortCount";
	public static final String TOTAL_SOLUTION_COUNT = "totalSolutionCount";
	public static final String HAS_COMPLETED_EVENT = "hasCompletedEvent";
	public static final String EVENT_COUNT_DOWN_COUNTER = "eventCountDownCounter";
	public static final String TRY_AFTER_N_SECOND = "tryafterNSec";
	public static final String LOCK_FOR_N_SECOND = "tryafterNSec";
	public static String MODELS_CALCULATED_SINCE_START = "modelCalculatedSInceStart";
	public static final String ACTIVE_RUN_COUNTER = "activeRunCounter";	
	public static int TOTAL_EVENT_COUNT =0;
	public static int MAX_THREAD_EXEC_LIMIT=250;
	public static String MAIL_TO_LIST ="gail.thomas@ge.com,girija.kartikey@ge.com,sudipto.saha@ge.com,pw.icamarnotifications@ge.com";
	public static String MAIL_FROM = "gail.thomas@ge.com";
	
	public static final String MODEL_PATH_WAIT_LIST ="waitPathList";
	public static final String TOTAL_EVENT_PROCESSED_COUNTER ="totalEventProcessedCounter";
	
	public static final String HEALTH_CHECK_MAP = "healthcheck";
	public static final String HEALTH_MODEL_STATS_MAP = "modelStats";
	/**********************Hazalcast Run COnfiguration Parameters**************************************/
	/**
	 * Map for weighting event types
	 **/
public static final Map<String,Float> EVENT_TYPE_WEIGHT_MAP=new HashMap<String,Float>(){{
		put("CI-Insp",1f);
		put("CI",1.1f);		
		put("HGP",2.1f);
		put("HGP-Insp",2f); 
		put("MI",3f);	
		put("EOT",4f);
		put("NO EVNT",-1f);
		
	}};
	public static final Map<Float,String> WEIGHT_TYPE_EVENT_MAP=new HashMap<Float,String>(){{
		put(1f,"CI-Insp");
		put(1.1f,"CI");		
		put(2.1f,"HGP");
		put(2f,"HGP-Insp"); 
		put(3f,"MI");	
		put(4f,"EOT");
		put(-1f,"NO EVNT");
		
	}};
	
	public static final int AR_SIM_THRESHOLD_LIMIT = 30;
	public static final String EVENT_TIME = "eventtime";
	public static final String RESULTS_MAP = "finalResults";
	
	public static final String  CLIENT_FILE_NAME_PREFIX = "hazelcast-client-";
	public static final String  CLIENT_PRIMARY_SUFFIX = "primary";
	public static final String  CLIENT_SECONDARY_SUFFIX = "secondary";
	public static final String  CLIENT_FILE_EXTN = ".xml";
	public static final String HC_CLIENT_ROUTER = "hcRouterDao";
	public static final boolean ENABLE_SECONDARY=true;
	
	/**
	 * Changed for Queue+Map implementation
	 */
	public static final String MODEL_PATH_WAIT_QUEUE ="waitPathQueue";
	
	public static final String HC_TASK_MAP ="hazelcastTaskMap";
	public static final String CURRENT_COMPLETION_COUNT = "currentCompletionCount";
	public static final String MODEL_PATH_WAIT_LIST_LOCK = "";
	
	public static final int MAX_CONCURRENT_PATH_COUNT = 75;
	public static final int MAX_FLEET_CONCURRENT_PATH_COUNT = 25;
	public static final double MIN_EXECUTING_PERCENTAGE = 40.0; /*percent*/
	public static final String LONG_RUNNING_MODEL = "longRunningModel";
	public static final int MAX_LONG_RUNNING_TIME = 15; /*minutes*/
	public static final String AR_MAIL_SERVER="schs03.sch.ge.com";
	public static final String AR_MAIL_SERVER_PORT="25";
	
	public static final String LOG_MAP = "logMap";
	
	public static final double PHANTOM_PERIOD = 180;
	
	public static final int LOGGING_LEVEL_TRACE = 1;
	public static final int LOGGING_LEVEL_INFO =  2;
	public static final int LOGGING_LEVEL_DEBUG = 3;
	public static final int LOGGING_LEVEL_WARN =  4;
	public static final int LOGGING_LEVEL_ERROR = 5;
	
	public static final String AR_TECH_ERR = "AR_TECH_ERR";
	public static final String AR_FUNC_ERR = "AR_FUNC_ERR";
		
	public static final boolean METRICS_TRACK = true;
    public static final boolean IS_METRIC = true;

	//Added for Enhancement ST/GEN as Driver - 141939291 
	public static final String GAS_TURBINE = "Gas Turbine";
	public static final String STEAM_TURBINE =  "Steam Turbine";
	public static final String GENERATOR =  "Generator";
	
	public static final String ESN_SEPARATOR_VAL =  "@#$";
	public static final int ESN_SEPARATOR_LEN =  3;
	
}

