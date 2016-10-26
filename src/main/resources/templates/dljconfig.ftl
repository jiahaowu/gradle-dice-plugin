#!/usr/bin/env bash

###############################################################################
# @ddblock_begin copyright
#
# Copyright (c) 1999-2016
# Maryland DSPCAD Research Group, The University of Maryland at College Park
# All rights reserved.

# IN NO EVENT SHALL THE UNIVERSITY OF MARYLAND BE LIABLE TO ANY PARTY
# FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES
# ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
# THE UNIVERSITY OF MARYLAND HAS BEEN ADVISED OF THE POSSIBILITY OF
# SUCH DAMAGE.

# THE UNIVERSITY OF MARYLAND SPECIFICALLY DISCLAIMS ANY WARRANTIES,
# INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
# MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
# PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
# MARYLAND HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
# ENHANCEMENTS, OR MODIFICATIONS.
#
# @ddblock_end copyright
###############################################################################

# Script to configure this package

dljclasspath="${ext.getDljclasspath()}"
dljtargetfile="${ext.getDljtargetfile()}"
dljinstalldir="${ext.getDljinstalldir()}"
dljcls="${ext.getDljcls()}"
dljverbose="${ext.getDljverbose()}"