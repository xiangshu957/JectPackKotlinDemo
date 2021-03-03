package com.rokin.wms.jectpackkotlin.constants

/**
 * @Author: ZhangRuixiang
 * Date: 2020/12/24
 * DES:
 */
object Constant {
    const val SP_NAME = "wms_sp"
    const val RELEASE = "release"
    const val TEST = "test"
    const val UAT = "uat"
    const val CUSTOM = "custom"
    const val LAST_SELECT = "last_select"
    const val USERNAME = "UserName"
    const val PASSWORD = "Password"
    var address: String? = null
    const val RELEASE_ADDRESS = "http://wms.rokin.cn:8011/"
    const val TEST_ADDRESS = "http://dev.rokin.cn:20005/"
    const val UAT_ADDRESS = "http://uat.rokin.cn:20005/"
    const val CUSTOM_ADDRESS = "http://uat.rokin.cn:20005/"
    const val TYPE_RECEIVE_RECEIVING_INVENTORY = "收货清点"
    const val TYPE_RECEIVE_ONSHELF_OPERATION = "上架操作"
    const val TYPE_RECEIVE_STORAGE_SCANNING = "入库扫描"
    const val TYPE_RECEIVE_ONSHELF_MOVE_WAREHOUSE = "上架移库"
    const val TYPE_PICKING_DELIVERY_OPERATION = "发货操作"
    const val TYPE_PICKING_OUTBOUND_SCANNING = "出库扫描"
    const val TYPE_PICKING_PICKING_REVIEW = "拣货复核"
    const val TYPE_PICKING_PICKING_SCANNING = "拣货扫描"
    const val TYPE_PICKING_WAREHOUSE_INSPECTION_TRANSFER = "巡仓移库"
    const val TYPE_PACKING_PACKING_SCAN = "装箱扫描"
    const val TYPE_PACKING_PACKING_WEIGHING = "装箱称重"
    const val TYPE_INFO_INVENTORY_CHECKING = "库存盘点"
    const val TYPE_INFO_INVENTORY_QUERY = "库存查询"
    const val TYPE_INFO_TASK_INVENTORY_LIST = "任务盘点"
    const val TYPE_INFO_WAREHOUSE_INSPECTION_TRANSFER = "巡仓移库"
    const val TYPE_SEND_DELIVERY_CONFIRMATION = "发货确认"
    const val TYPE_SEND_TRANSFER_BOX_SCANNING = "中转箱扫描"
    const val AROUTER_MENU = "/app/activity/MenuActivity"
    const val AROUTER_LOGIN = "/app/activity/LoginActivity"
    const val AROUTER_CLIENT = "/app/activity/ClientActivity"
    const val AROUTER_RECEIVE_STORAGE_SCANNING =
        "/app/activity/receive/StorageScanningActivity"
    const val AROUTER_RECEIVE_RECEIVING_INVENTORY =
        "/app/activity/receive/ReceivingInventoryActivity"
    const val AROUTER_RECEIVE_ONSHELF_OPERATION =
        "/app/activity/receive/OnShelfOperationActivity"
    const val AROUTER_RECEIVE_ONSHELF_MOVE_WAREHOUSE =
        "/app/activity/receive/OnShelfMoveWarehouseActivity"
    const val AROUTER_PICKING_DELIVERY_OPERATION =
        "/app/activity/picking/DeliveryOperation"
    const val AROUTER_PICKING_OUTBOUND_SCANNING =
        "/app/activity/picking/OutboundScanningActivity"
    const val AROUTER_PICKING_PICKING_REVIEW =
        "/app/activity/picking/PickingReviewActivity"
    const val AROUTER_PICKING_PICKING_SCANNING =
        "/app/activity/picking/PickingScanningActivity"
    const val AROUTER_PICKING_WAREHOUSE_INSPECTION_TRANSFER =
        "/app/activity/picking/WarehouseInspectionTransferActivity"
    const val AROUTER_PACKING_PACKING_SCAN = "/app/activity/packing/PackingScanActivity"
    const val AROUTER_PACKING_PACKING_WEIGHING =
        "/app/activity/packing/PackingWeighingActivity"
    const val AROUTER_INFO_INVENTORY_CHECKING =
        "/app/activity/info/InventoryCheckingActivity"
    const val AROUTER_INFO_INVENTORY_QUERY = "/app/activity/info/InventoryQueryActivity"
    const val AROUTER_INFO_TASK_INVENTORY_DETAIL =
        "/app/activity/info/TaskInventoryDetailActivity"
    const val AROUTER_INFO_TASK_INVENTORY_LIST =
        "/app/activity/info/TaskInventoryListActivity"
    const val AROUTER_INFO_WAREHOUSE_INSPECTION_TRANSFER =
        "/app/activity/info/WarehouseInspectionTransferActivity"
    const val AROUTER_SEND_DELIVERY_CONFIRMATION =
        "/app/activity/send/DeliveryConfirmationActivity"
    const val AROUTER_SEND_TRANSFER_BOX_SCANNING =
        "/app/activity/send/TransferBoxScanningActivity"
}