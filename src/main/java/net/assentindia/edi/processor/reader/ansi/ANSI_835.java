/*
 * Copyright 2005-2015 by BerryWorks Software, LLC. All rights reserved.
 *
 * This file is part of EDIReader. You may obtain a license for its use directly from
 * BerryWorks Software, and you may also choose to use this software under the terms of the
 * GPL version 3. Other products in the EDIReader software suite are available only by licensing
 * with BerryWorks. Only those files bearing the GPL statement below are available under the GPL.
 *
 * EDIReader is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * EDIReader is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with EDIReader.  If not,
 * see <http://www.gnu.org/licenses/>.
 */

package net.assentindia.edi.processor.reader.ansi;

import net.assentindia.edi.processor.reader.plugin.Plugin;

public class ANSI_835 extends Plugin {
    public ANSI_835() {
        super("835", "Health Care Claim Payment/Advice");
        loops = new LoopDescriptor[]{
                new LoopDescriptor("2100", "CLP", 2, "/2000/2100"),
                new LoopDescriptor("2100", "CLP", 2, "/2000"),
                new LoopDescriptor("2000", "LX", 1, ANY_CONTEXT),
                new LoopDescriptor("1000", "N1", 1, "/1000"),
                new LoopDescriptor("1000", "N1", 1, ANY_CONTEXT),
                new LoopDescriptor(CURRENT, "PLB", 0, ANY_CONTEXT),
                new LoopDescriptor("2110", "SVC", 3, "/2000/2100/2110"),
                new LoopDescriptor("2110", "SVC", 3, "/2000/2100"),
        };
    }
}
